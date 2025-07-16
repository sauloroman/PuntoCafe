package controllers.user;

import interfaces.HandlerController;
import controllers.user.handlers.ChangeUserStatusHandler;
import controllers.user.handlers.CreateUserHandler;
import controllers.user.handlers.EditUserHandler;
import controllers.user.handlers.QuantityUsersByRoleHandler;
import controllers.user.handlers.UserPaginationHandler;
import controllers.user.helpers.ResetElements;
import controllers.user.helpers.FillBoxes;
import controllers.user.helpers.FilterUsers;
import controllers.user.helpers.UserFromTable;
import controllers.user.helpers.LoadInformation;
import controllers.user.helpers.UploadUserImage;
import controllers.user.helpers.UserTableRefresher;
import controllers.user.helpers.UserValidator;
import entities.User;
import java.awt.event.ActionListener;
import models.RoleModel;
import models.UserModel;
import services.RoleService;
import services.UserService;
import utils.enums.SearchCriteriaEnum;
import utils.helpers.Modal;
import utils.helpers.SelectedRowTable;
import views.access.AccessCreateUser;
import views.access.AccessEditUser;
import views.access.AccessInfoUser;
import views.access.AccessRoles;
import views.access.AccessUsers;

public class UserController {
    
    private final AccessUsers view;
    private final AccessRoles rolesView;
    private final UserModel model;
    private final RoleModel roleModel;
    private final UserService userService;
    private final RoleService roleService;
    private final AccessCreateUser createUserView;
    private final AccessInfoUser infoUserView;
    private final AccessEditUser editUserView;
    private final FillBoxes fillBoxes;
    private final UploadUserImage upload;
    private final ResetElements reset;
    private final UserValidator validator;
    private final UserTableRefresher refresher;
    private final UserPaginationHandler paginationHandler;
    private final HandlerController createUserHandler;
    private final HandlerController editUserHandler;
    private final HandlerController quantityUsersByRoleHandler;
    private final SelectedRowTable selectedRow;
    private final LoadInformation loadUserInfo;
    private final UserFromTable fromTable;
    private final FilterUsers filter;
    private final ChangeUserStatusHandler activateUser;
    private final ChangeUserStatusHandler deactivateUser;
    private final Modal modal = new Modal("Usuarios del sistema - PuntoCafé");
    private User userSelected = null;
    
    public UserController(
            AccessUsers view, 
            AccessRoles rolesView,
            UserModel model,
            RoleModel roleModel
    ) {
        this.view = view;
        this.rolesView = rolesView;
        this.model = model;
        this.roleModel = roleModel;
        
        this.createUserView = new AccessCreateUser();
        this.infoUserView = new AccessInfoUser();
        this.editUserView = new AccessEditUser();
        
        this.userService = new UserService(this.model);
        this.roleService = new RoleService(this.roleModel);
        
        this.paginationHandler = new UserPaginationHandler(view, userService, roleService);
        this.validator = new UserValidator(createUserView, editUserView, modal);
        this.fillBoxes = new FillBoxes(createUserView, editUserView);
        this.upload = new UploadUserImage(createUserView, editUserView, modal);
        this.reset = new ResetElements(view, createUserView, editUserView);
        this.refresher = new UserTableRefresher(paginationHandler);
        this.selectedRow = new SelectedRowTable(modal, view.usersTable);
        this.loadUserInfo = new LoadInformation(infoUserView, editUserView, roleService);
        this.fromTable = new UserFromTable(view, userService);
        this.filter = new FilterUsers(view);
        
        this.quantityUsersByRoleHandler = new QuantityUsersByRoleHandler(rolesView, roleService, userService);
        this.createUserHandler = new CreateUserHandler(createUserView, userService, roleService, modal);
        this.editUserHandler = new EditUserHandler(editUserView, userService, roleService, modal);
        this.activateUser = new ChangeUserStatusHandler(userService, true, modal);
        this.deactivateUser = new ChangeUserStatusHandler(userService, false, modal);
        
        init();
        initListeners();
    }
    
    private void init() {
        quantityUsersByRoleHandler.execute();
        paginationHandler.execute();
        fillBoxes.fillRoleBox(roleService.getRoles());
        fillBoxes.fillRoleEditBox(roleService.getRoles());
        setTotalUsers();
    }
    
    private void initListeners() {
        view.btnNewUser.addActionListener(e -> openCreateUserWindow());
        view.btnSeeUser.addActionListener(e -> openInfoUserWindow());
        view.pageCombo.addActionListener(e -> paginationHandler.executeLoadSelectedPage(SearchCriteriaEnum.NAME));
        view.itemsPerPageComboBox.addActionListener(e -> safelyRebuildPagination(SearchCriteriaEnum.NAME));
        view.userRoleCombo.addActionListener(e -> filterUsersByRole());
        view.btnRestore.addActionListener(e -> restoreFilters());
        view.btnSearch.addActionListener(e -> filterUsersByName());
        
        createUserView.btnCancelSaveUser.addActionListener(e -> closeCreateUserWindow());
        createUserView.btnLoad.addActionListener(e -> uploadImage(false));
        createUserView.btnRemove.addActionListener(e -> removeImage());
        createUserView.btnSaveUser.addActionListener(e -> createUser());
        createUserView.btnShowConfirmPassword.addActionListener(e -> reset.showPassword(createUserView.userConfirmPassTxt));
        createUserView.btnShowPassword.addActionListener( e -> reset.showPassword(createUserView.userPassTxt)); 
        
        infoUserView.btnEdit.addActionListener(e -> openEditUserWindow());
        infoUserView.btnActivate.addActionListener(e -> activateUser());
        infoUserView.btnDeactivate.addActionListener(e -> deactivateUser());
        
        editUserView.btnEditUser.addActionListener(e -> editUser());
        editUserView.btnLoad.addActionListener( e -> uploadImage(true) );
        editUserView.btnRemove.addActionListener( e -> removeImage() );
        editUserView.btnCancelEditUser.addActionListener(e -> closeEditUser());
    }
    
    private void restoreFilters() {
        safelyRebuildPagination(SearchCriteriaEnum.NAME);
        filter.restoreRoleSelected();
        filter.restoreUserSearched();
        reset.showPagination();
    }
    
    private void filterUsersByName() {
        String userSearched = filter.getUserSearched();
        
        if ( userSearched == null ) {
            restoreFilters();
            return;
        }
        
        refresher.refresh(SearchCriteriaEnum.NAME, userSearched);
        reset.hidePagination();
    }
    
    private void filterUsersByRole() {
        String selectedRole = filter.getRoleSelected();
        
        if ( selectedRole == null ) {
            restoreFilters();
            return;
        }
        
        String roleId = String.valueOf(roleService.getRoleByName(selectedRole).getRoleId());
        refresher.refresh(SearchCriteriaEnum.USER_ROLE, roleId);
        reset.hidePagination();
    }
    
    private void closeEditUser() {
        editUserView.setVisible(false);
        reset.hideButtonUploadImage();
        reset.clearEditUserForm();
    }
    
    private void editUser() {
        if (!validator.isValidEdition()) return;
        
        if (!upload.handleUploadForEdit()) {
            ((EditUserHandler) editUserHandler).setImage("no-image.jpg");
        } else {
            ((EditUserHandler) editUserHandler).setImage(upload.image);
        }
        
        ((EditUserHandler) editUserHandler).setId(userSelected.getUserId());
        ((EditUserHandler) editUserHandler).setEmail(userSelected.getUserEmail());
        
        editUserHandler.execute();
        safelyRebuildPagination(SearchCriteriaEnum.NAME);
        reset.clearEditUserForm();
        reset.hideButtonUploadImage();
        upload.removeImage();
        setTotalUsers();
        editUserView.setVisible(false);
        infoUserView.setVisible(false);
        quantityUsersByRoleHandler.execute();
    }
    
    private void openEditUserWindow() {
        if ( userSelected == null ) return;
        reset.hideButtonUploadImage();
        loadUserInfo.loadInfoEdit(userSelected);
        editUserView.setVisible(true);
    }
    
    private void activateUser() {
        if ( userSelected == null ) return;
        if ( !activateUser.isValidStatus(userSelected.getIsActive())) return;
        if ( !activateUser.confirmChange() ) return;
        
        activateUser.change( userSelected.getUserId() );
        safelyRebuildPagination(SearchCriteriaEnum.NAME);
        infoUserView.setVisible(false);
    }
    
    private void deactivateUser() {
        if ( userSelected == null ) return;
        if ( !deactivateUser.isValidStatus(userSelected.getIsActive())) return;
        if ( !deactivateUser.confirmChange() ) return;
        
        deactivateUser.change( userSelected.getUserId() );
        safelyRebuildPagination(SearchCriteriaEnum.NAME);
        infoUserView.setVisible(false);
    }
    
    private void createUser() {
        if ( !validator.isValidCreation() ) return;
        
        if (!upload.handleUploadForCreate()) {
            ((CreateUserHandler) createUserHandler).setImage("no-image.jpg");
        } else {
            ((CreateUserHandler) createUserHandler).setImage(upload.image);
        }
        
        createUserHandler.execute();
        safelyRebuildPagination(SearchCriteriaEnum.NAME);
        reset.clearCreateUserForm();
        setTotalUsers();
        createUserView.setVisible(false);
        upload.removeImage();
        quantityUsersByRoleHandler.execute();
    }
    
    private void openInfoUserWindow() {
        if ( !selectedRow.validate("Selecciona un usuario") ) return;
        userSelected = fromTable.getUser(selectedRow.getSelectedRow());
        
        loadUserInfo.loadInfoUser(userSelected);
        infoUserView.setVisible(true);
    }
    
    private void openCreateUserWindow() {
        reset.showButtonUploadImage();
        createUserView.setVisible(true);
    }
    
    private void closeCreateUserWindow() {
        createUserView.setVisible(false);
    }
    
    private void removeImage() {
        upload.removeImage();
        reset.showButtonUploadImage();
    }
    
    private void uploadImage( boolean isEdit ) {
        upload.load(isEdit);
        reset.hideButtonUploadImage();
    }
    
    private void safelyRebuildPagination(SearchCriteriaEnum criteria) {
        ActionListener[] listeners = view.pageCombo.getActionListeners();
        for (ActionListener l : listeners) {
            view.pageCombo.removeActionListener(l);
        }

        paginationHandler.executeRebuildPagination(criteria);

        for (ActionListener l : listeners) {
            view.pageCombo.addActionListener(l);
        }
    }
    
    private void setTotalUsers() {
        view.quantityUsers.setText(userService.getQuantityUsers() + "");
    }
    
}

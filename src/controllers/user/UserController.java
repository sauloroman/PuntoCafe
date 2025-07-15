package controllers.user;

import controllers.interfaces.HandlerController;
import controllers.user.handlers.CreateUserHandler;
import controllers.user.handlers.UserPaginationHandler;
import controllers.user.helpers.ResetElements;
import controllers.user.helpers.FillBoxes;
import controllers.user.helpers.GetUserFromTable;
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
import views.access.AccessInfoUser;
import views.access.AccessUsers;

public class UserController {
    
    private final AccessUsers view;
    private final UserModel model;
    private final RoleModel roleModel;
    private final UserService userService;
    private final RoleService roleService;
    private final AccessCreateUser createUserView;
    private final AccessInfoUser infoUserView;
    private final FillBoxes fillBoxes;
    private final UploadUserImage upload;
    private final ResetElements reset;
    private final UserValidator validator;
    private final UserTableRefresher refresher;
    private final UserPaginationHandler paginationHandler;
    private final HandlerController createUserHandler;
    private final SelectedRowTable selectedRow;
    private final LoadInformation loadUserInfo;
    private final GetUserFromTable fromTable;
    private final Modal modal = new Modal("Usuarios del sistema - PuntoCafé");
    private User userSelected = null;
    
    public UserController(
            AccessUsers view, 
            UserModel model,
            RoleModel roleModel
    ) {
        this.view = view;
        this.model = model;
        this.roleModel = roleModel;
        
        this.createUserView = new AccessCreateUser();
        this.infoUserView = new AccessInfoUser();
        
        this.userService = new UserService(this.model);
        this.roleService = new RoleService(this.roleModel);
        
        this.paginationHandler = new UserPaginationHandler(view, userService, roleService);
        this.validator = new UserValidator(createUserView, modal);
        this.fillBoxes = new FillBoxes(createUserView);
        this.upload = new UploadUserImage(createUserView, modal);
        this.reset = new ResetElements(createUserView);
        this.refresher = new UserTableRefresher(paginationHandler);
        this.selectedRow = new SelectedRowTable(modal, view.usersTable);
        this.loadUserInfo = new LoadInformation(infoUserView, roleService);
        this.fromTable = new GetUserFromTable(view, userService);
        
        this.createUserHandler = new CreateUserHandler(createUserView, userService, roleService, modal);
        
        init();
        initListeners();
    }
    
    private void init() {
        paginationHandler.execute();
        fillBoxes.fillRoleBox(roleService.getRoles());
        setTotalUsers();
    }
    
    private void initListeners() {
        view.btnNewUser.addActionListener(e -> openCreateUserWindow());
        view.btnSeeUser.addActionListener(e -> openInfoUserWindow());
        
        createUserView.btnCancelSaveUser.addActionListener(e -> closeCreateUserWindow());
        createUserView.btnLoad.addActionListener(e -> uploadImage(false));
        createUserView.btnRemove.addActionListener(e -> removeImage());
        createUserView.btnSaveUser.addActionListener(e -> createUser());
        createUserView.btnShowConfirmPassword.addActionListener(e -> reset.showPassword(createUserView.userConfirmPassTxt));
        createUserView.btnShowPassword.addActionListener( e -> reset.showPassword(createUserView.userPassTxt)); 
        
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
    }
    
    private void openInfoUserWindow() {
        if ( !selectedRow.validate("Selecciona un usuario") ) return;
        userSelected = fromTable.getUser(selectedRow.getSelectedRow());
        
        loadUserInfo.loadInfoUser(userSelected);
        infoUserView.setVisible(true);
    }
    
    private void openCreateUserWindow() {
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

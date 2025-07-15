package controllers.user;

import controllers.interfaces.HandlerController;
import controllers.user.handlers.CreateUserHandler;
import controllers.user.handlers.UserPaginationHandler;
import controllers.user.helpers.ResetElements;
import controllers.user.helpers.FillBoxes;
import controllers.user.helpers.UploadUserImage;
import controllers.user.helpers.UserTableRefresher;
import controllers.user.helpers.UserValidator;
import java.awt.event.ActionListener;
import models.RoleModel;
import models.UserModel;
import services.RoleService;
import services.UserService;
import utils.enums.SearchCriteriaEnum;
import utils.helpers.Modal;
import views.access.AccessCreateUser;
import views.access.AccessUsers;

public class UserController {
    
    private final AccessUsers view;
    private final UserModel model;
    private final RoleModel roleModel;
    private final UserService userService;
    private final RoleService roleService;
    private final AccessCreateUser createUserView;
    private final FillBoxes fillBoxes;
    private final UploadUserImage upload;
    private final ResetElements reset;
    private final UserValidator validator;
    private final UserTableRefresher refresher;
    private final UserPaginationHandler paginationHandler;
    private final HandlerController createUserHandler;
    private final Modal modal = new Modal("Usuarios del sistema - PuntoCafé");
    
    public UserController(
            AccessUsers view, 
            UserModel model,
            RoleModel roleModel
    ) {
        this.view = view;
        this.model = model;
        this.roleModel = roleModel;
        
        this.createUserView = new AccessCreateUser();
        
        this.userService = new UserService(model);
        this.roleService = new RoleService(roleModel);
        
        this.paginationHandler = new UserPaginationHandler(view, userService, roleService);
        this.validator = new UserValidator(createUserView, modal);
        this.fillBoxes = new FillBoxes(createUserView);
        this.upload = new UploadUserImage(createUserView, modal);
        this.reset = new ResetElements(createUserView);
        this.refresher = new UserTableRefresher(paginationHandler);
        
        this.createUserHandler = new CreateUserHandler(createUserView, userService, roleService, modal);
        
        init();
        initListeners();
    }
    
    private void init() {
        paginationHandler.execute();
        fillBoxes.fillRoleBox(roleService.getRoles());
    }
    
    private void initListeners() {
        
        view.btnNewUser.addActionListener(e -> openCreateUserWindow());
        
        createUserView.btnCancelSaveUser.addActionListener(e -> closeCreateUserWindow());
        createUserView.btnLoad.addActionListener(e -> uploadImage(false));
        createUserView.btnRemove.addActionListener(e -> removeImage());
        createUserView.btnSaveUser.addActionListener(e -> createUser());
        
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
        safelyRebuildPagination(SearchCriteriaEnum.NAME);
        createUserView.setVisible(false);
        upload.removeImage();
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
    
}

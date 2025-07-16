package controllers.user.handlers;

import interfaces.ChangeStatusNoTableInterface;
import services.UserService;
import utils.enums.ModalTypeEnum;
import utils.helpers.Modal;

public class ChangeUserStatusHandler implements ChangeStatusNoTableInterface {

    private final UserService service;
    private final boolean activate;
    private final Modal modal;

    public ChangeUserStatusHandler(UserService service, boolean activate, Modal modal) {
        this.service = service;
        this.activate = activate;
        this.modal = modal;
    }

    @Override
    public boolean isValidStatus(boolean status) {
        if( activate && status ) {
            modal.show("El usuario ya está activo", ModalTypeEnum.warning);
            return false;
        }
        
        if( !activate && !status ) {
            modal.show("El usuario ya está inactivo", ModalTypeEnum.warning);
            return false;
        }
        
        return true;    }

    @Override
    public boolean change(int id) {
    
        boolean wasStatusChanged = activate ? service.activateUser(id) : service.deactivateUser(id);
        
        if ( !wasStatusChanged ) {
            modal.show("El estado del usuario no pudo ser cambiado", ModalTypeEnum.warning);
            return false; 
        }
        
        modal.show("El estado del usuario ha cambiado", ModalTypeEnum.success);
        return true;
        
    }

    @Override
    public boolean confirmChange() {
        return modal.confirm("¿Está seguro de cambiar el estado del usuario?") == 0;
    }
    
}

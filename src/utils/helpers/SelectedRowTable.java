package utils.helpers;

import javax.swing.JTable;
import utils.enums.ModalTypeEnum;

public final class SelectedRowTable {

    private final Modal modal;
    private final JTable table;
    
    public SelectedRowTable( Modal modal, JTable table ) {
        this.modal = modal;
        this.table = table;
    }
        
    public boolean validate(String message) {
        if ( table.getSelectedRowCount() == 0 ) {
            modal.show(message, ModalTypeEnum.error);
            return false;
        }
        return true;
    }
    
    public int getSelectedRow() {
        return table.getSelectedRow();
    }
    
}

package controllers.supplier.helpers;

import javax.swing.JTable;

public final class SelectedRowTable {

    private final JTable table;
    
    public SelectedRowTable( JTable table ) {
        this.table = table;
    }
        
    public boolean validate() {
        return table.getSelectedRowCount() != 0;
    }
    
    public int getSelectedRow() {
        return table.getSelectedRow();
    }
    
    public String getStatus() {
        return table.getValueAt(getSelectedRow(), 9).toString();
    }
    
    public String getName() {
        return table.getValueAt(getSelectedRow(), 1).toString();
    }
    
    public int getId() {
        return Integer.parseInt(table.getValueAt(getSelectedRow(), 0).toString());
    }
    
}

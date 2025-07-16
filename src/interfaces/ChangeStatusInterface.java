package interfaces;

public interface ChangeStatusInterface {
    
    public boolean change( int row );
    public boolean isStatusValid( int row );
    public boolean confirmChange(int row);
    
}

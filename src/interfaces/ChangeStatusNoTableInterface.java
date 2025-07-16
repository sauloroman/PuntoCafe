package interfaces;

public interface ChangeStatusNoTableInterface {
    public boolean isValidStatus(boolean status);
    public boolean change(int id);
    public boolean confirmChange();
}

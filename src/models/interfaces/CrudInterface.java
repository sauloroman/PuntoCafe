package models.interfaces;

import java.util.List;
import utils.enums.SearchCriteriaEnum;

public interface CrudInterface<T> {
    public T getItemByName( String name );
    public T getItemById( int id );
    public List<T> listItems( String filter );
    public List<T> listItemsByPage( String filter, SearchCriteriaEnum criteria, int page, int itemsPerPage );
    public boolean saveItem(T obj);
    public boolean changeStatus( int id, boolean status );
    public boolean updateItem( T obj, int id );
    public int getTotalItems();
}

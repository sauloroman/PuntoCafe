package utils.builders;

import entities.User;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class UserTableBuilder {

    public static DefaultTableModel create(List<User> users) {
        String[] columnsTable = {"Id", "Usuario", "Role", "Fecha de creación", "Última actualización"};
        DefaultTableModel table = new DefaultTableModel(null, columnsTable);

        Object[] rowTable = new Object[5];

        for (User user : users) {

            rowTable[0] = user.getUserId();
            
            rowTable[1] = new UserCellData(
                user.getUserName() + " " + user.getUserLastname(),
                user.getUserEmail(),
                user.getUserImage()
            );
            
            //rowTable[2] = new String[] {role};
            rowTable[3] = user.getUserCreatedAt(); 
            rowTable[4] = user.getUserUpdatedAt();

            table.addRow(rowTable);
        }

        return table;
    }

}

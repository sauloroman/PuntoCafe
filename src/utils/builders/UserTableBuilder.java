package utils.builders;

import entities.User;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import services.RoleService;

public class UserTableBuilder {

    public static DefaultTableModel create(List<User> users, RoleService roleService ) {
        String[] columnsTable = {"Id", "Usuario", "Role", "Fecha de creación", "Última actualización", "Estado" };
        DefaultTableModel table = new DefaultTableModel(null, columnsTable){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        Object[] rowTable = new Object[6];

        for (User user : users) {

            rowTable[0] = user.getUserId();
            
            rowTable[1] = new UserCellData(
                user.getUserName() + " " + user.getUserLastname(),
                user.getUserEmail(),
                user.getUserImage()
            );
            
            String roleName = roleService.getRoleById(user.getRoleId()).getRoleName();
            rowTable[2] = new String[] {roleName};
            rowTable[3] = user.getUserCreatedAt(); 
            rowTable[4] = user.getUserUpdatedAt();
            rowTable[5] = user.getIsActive() ? "Activo" : "Inactivo";

            table.addRow(rowTable);
        }

        return table;
    }

}

package utils.builders;

import entities.User;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import services.RoleService;

public class UserTableBuilder {

    public static DefaultTableModel create(List<User> users, RoleService roleService ) {
        String[] columnsTable = {"Id", "Usuario", "Email", "Role", "Fecha de creación", "Última actualización", "Estado" };
        DefaultTableModel table = new DefaultTableModel(null, columnsTable){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        Object[] rowTable = new Object[7];

        for (User user : users) {

            rowTable[0] = user.getUserId();
            
            rowTable[1] = new UserCellData(
                user.getUserName() + " " + user.getUserLastname(),
                user.getUserImage()
            );
            
            rowTable[2] = user.getUserEmail();
            
            String roleName = roleService.getRoleById(user.getRoleId()).getRoleName();
            rowTable[3] = new String[] {roleName};
            rowTable[4] = user.getUserCreatedAt(); 
            rowTable[5] = user.getUserUpdatedAt();
            rowTable[6] = user.getIsActive() ? "Activo" : "Inactivo";

            table.addRow(rowTable);
        }

        return table;
    }

}

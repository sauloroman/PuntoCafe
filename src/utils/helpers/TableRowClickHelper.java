package utils.helpers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;
import javax.swing.JTable;

public class TableRowClickHelper {
    
    public static void addRowClickListener(JTable table, Consumer<Integer> callback) {
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                if (row >= 0) {
                    callback.accept(row);
                }
            }
        });
    }
    
}

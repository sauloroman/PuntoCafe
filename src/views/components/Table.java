package views.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTable;

public final class Table {
    
    public static void tableStyle1( JTable table ) {
        table.getTableHeader().setBackground(Color.decode("#F1F3F5"));
        table.getTableHeader().setForeground(Color.decode("#1E1E1E")); 
        table.getTableHeader().setFont(new Font("sansserif", Font.BOLD, 12));
        table.getTableHeader().setReorderingAllowed(false);
        table.setBackground(Color.WHITE);
        table.setForeground(Color.decode("#1E1E1E"));
        table.setRowHeight(30);
        table.setShowGrid(true); 
        table.setSelectionBackground(Color.decode("#F5F5F5"));
        table.setSelectionForeground(Color.decode("#1E1E1E"));
        table.setGridColor(Color.decode("#E0E0E0")); 
    }
    
    public static void tableStyle2( JTable table ) {
         // Encabezado de la tabla
        table.getTableHeader().setBackground(Color.decode("#F1F3F5"));
        table.getTableHeader().setForeground(Color.decode("#1E1E1E"));
        table.getTableHeader().setFont(new Font("sansserif", Font.PLAIN, 12));
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setOpaque(true);

        // Tabla (cuerpo)
        table.setBackground(Color.WHITE);
        table.setForeground(Color.decode("#202124"));
         table.setFont(new Font("sansserif", Font.PLAIN, 12));
        table.setRowHeight(30);

        // Selección
        table.setSelectionBackground(Color.decode("#E8F0FE")); // Azul muy claro
        table.setSelectionForeground(Color.decode("#202124"));

        // Líneas de separación
        table.setShowHorizontalLines(true);
        table.setGridColor(Color.decode("#E0E0E0")); // Gris claro para líneas

        // Espaciado de filas
        table.setIntercellSpacing(new Dimension(0, 0));
    }
    
    
}

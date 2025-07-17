package views.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTable;

public final class Table {

    public static void tableStyle1(JTable table) {
        table.getTableHeader().setBackground(Color.decode("#F1F3F5"));
        table.getTableHeader().setForeground(Color.decode("#1E1E1E"));
        table.getTableHeader().setFont(new Font("sansserif", Font.BOLD, 12));
        table.getTableHeader().setReorderingAllowed(false);

        table.setBackground(Color.WHITE);
        table.setForeground(Color.decode("#1E1E1E"));
        table.setRowHeight(30);

        table.setShowGrid(true); // Mostrar líneas de cuadrícula
        table.setGridColor(Color.decode("#DDDDDD")); // Borde de celda #DDDDDD

        table.setSelectionBackground(Color.decode("#F5F5F5"));
        table.setSelectionForeground(Color.decode("#1E1E1E"));
    }

    public static void tableStyle2(JTable table) {
        table.getTableHeader().setBackground(Color.decode("#F1F3F5"));
        table.getTableHeader().setForeground(Color.decode("#1E1E1E"));
        table.getTableHeader().setFont(new Font("sansserif", Font.PLAIN, 12));
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setOpaque(true);

        table.setBackground(Color.WHITE);
        table.setForeground(Color.decode("#202124"));
        table.setFont(new Font("sansserif", Font.PLAIN, 12));
        table.setRowHeight(30);

        table.setSelectionBackground(Color.decode("#E8F0FE"));
        table.setSelectionForeground(Color.decode("#202124"));

        table.setIntercellSpacing(new Dimension(0, 0));
    }

    public static void tableStyle3(JTable table) {
        table.getTableHeader().setBackground(Color.decode("#F9FAFB"));
        table.getTableHeader().setForeground(Color.decode("#111827"));
        table.getTableHeader().setFont(new Font("sansserif", Font.BOLD, 12));
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setOpaque(true);

        table.setBackground(Color.WHITE);
        table.setForeground(Color.decode("#374151"));
        table.setFont(new Font("sansserif", Font.PLAIN, 12));
        table.setRowHeight(50);

        table.setSelectionBackground(Color.decode("#E8F0FE"));
        table.setSelectionForeground(Color.decode("#111827"));

        table.setIntercellSpacing(new Dimension(0, 0));
    }

}

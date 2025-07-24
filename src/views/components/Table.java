package views.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import utils.constants.ViewConstants;

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
    
    public static void tableDashboardStyle(JTable table) {
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.decode("#263358"));
        header.setForeground(Color.decode("#FFFFFF"));
        header.setFont(new Font("SansSerif", Font.BOLD, 12));
        header.setReorderingAllowed(false);
        header.setPreferredSize(new Dimension(header.getWidth(), 30));

        table.setBackground(Color.WHITE);
        table.setForeground(Color.decode("#1E1E1E"));
        table.setFont(new Font("SansSerif", Font.PLAIN, 11));
        table.setRowHeight(20);
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 0));

        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            private final Color borderColor = Color.decode("#E5E5E5");

            @Override
            public Component getTableCellRendererComponent(JTable table,
                                                           Object value,
                                                           boolean isSelected,
                                                           boolean hasFocus,
                                                           int row,
                                                           int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (!isSelected) {
                    c.setBackground(Color.WHITE);
                } else {
                    c.setBackground(new Color(240, 240, 240));
                }
                setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, borderColor));
                return c;
            }
        });
    }

    
}

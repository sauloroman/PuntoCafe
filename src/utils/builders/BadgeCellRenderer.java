package utils.builders;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class BadgeCellRenderer extends JPanel implements TableCellRenderer {

    public BadgeCellRenderer() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        removeAll();

        if (isSelected) {
            setBackground(table.getSelectionBackground());
        } else {
            setBackground(table.getBackground());
        }

        if (value instanceof String[]) {
            String[] badges = (String[]) value;

            for (String badge : badges) {
                JLabel badgeLabel = new JLabel(badge);
                badgeLabel.setOpaque(true);
                badgeLabel.setForeground(Color.WHITE);
                badgeLabel.setFont(new java.awt.Font("sansserif", java.awt.Font.PLAIN, 11));
                badgeLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 8, 2, 8));

                switch (badge.toLowerCase()) {
                    case "administrador" -> badgeLabel.setBackground(new Color(16, 185, 129));
                    case "vendedor" -> badgeLabel.setBackground(new Color(59, 130, 246));
                    case "supervisor" -> badgeLabel.setBackground(new Color(139, 92, 246));
                    default -> badgeLabel.setBackground(Color.GRAY);
                }

                add(badgeLabel);
            }
        }

        return this;
    }
}

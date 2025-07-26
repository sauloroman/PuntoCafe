package utils.builders;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class CategoryTypeBadgeCellRenderer extends JPanel implements TableCellRenderer {

    public CategoryTypeBadgeCellRenderer() {
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

        if (value instanceof String string) {
            String type = string.trim();

            JLabel badgeLabel = new JLabel(type);
            badgeLabel.setOpaque(true);
            badgeLabel.setForeground(Color.WHITE);
            badgeLabel.setFont(new java.awt.Font("sansserif", java.awt.Font.PLAIN, 11));
            badgeLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 8, 2, 8));

            switch (type.toLowerCase()) {
                case "platillo" -> badgeLabel.setBackground(Color.decode("#009688")); 
                case "producto" -> badgeLabel.setBackground(Color.decode("#3F51B5")); 
                default -> badgeLabel.setBackground(Color.GRAY);
            }

            add(badgeLabel);
        }

        return this;
    }
}

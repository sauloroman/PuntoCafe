package utils.builders;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import utils.constants.ViewConstants;

public class StatusBadgeCellRenderer extends JPanel implements TableCellRenderer {

    public StatusBadgeCellRenderer() {
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

        if (value instanceof String status) {
            JLabel badgeLabel = new JLabel(status);
            badgeLabel.setOpaque(true);
            badgeLabel.setForeground(Color.WHITE);
            badgeLabel.setFont(new java.awt.Font("sansserif", java.awt.Font.PLAIN, 11));
            badgeLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 8, 2, 8));

            switch (status.toLowerCase()) {
                case "activo" -> badgeLabel.setBackground(new Color(16, 185, 129));  // Verde
                case "inactivo" -> badgeLabel.setBackground(Color.decode(ViewConstants.errorColor)); // Rojo
                default -> badgeLabel.setBackground(Color.GRAY); // Fallback
            }

            add(badgeLabel);
        }

        return this;
    }
}

package utils.builders;

import entities.User;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class UserRoleBadgeCellRenderer extends JPanel implements TableCellRenderer {

    public UserRoleBadgeCellRenderer() {
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

        if (value instanceof User user) {
            JLabel badgeLabel = new JLabel(user.getUserName() + " " + user.getUserLastname()); 
            badgeLabel.setOpaque(true);
            badgeLabel.setForeground(Color.WHITE);
            badgeLabel.setFont(new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 11));
            badgeLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 8, 2, 8));

            int roleId = user.getRoleId();

            switch (roleId) {
                case 1 -> badgeLabel.setBackground(Color.decode("#9933FF"));
                case 2 -> badgeLabel.setBackground(Color.decode("#009933"));
                case 3 -> badgeLabel.setBackground(Color.decode("#FFCC00"));
                default -> badgeLabel.setBackground(Color.GRAY);
            }

            add(badgeLabel);
        }

        return this;
    }
}

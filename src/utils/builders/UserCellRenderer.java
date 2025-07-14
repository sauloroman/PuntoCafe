package utils.builders;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;

public class UserCellRenderer extends JPanel implements TableCellRenderer {
    
    private final JLabel imageLabel;
    private final JTextArea textArea;
    
    public UserCellRenderer() {
        
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        setOpaque(true);
        
        imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(30, 30));
        
        textArea = new JTextArea();
        textArea.setOpaque(false);
        textArea.setEditable(false);
        textArea.setFocusable(false);
        textArea.setFont(new Font("sansserif", Font.PLAIN, 10));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        
        add(imageLabel);
        add(textArea);
    }
    
    @Override
    public Component getTableCellRendererComponent(
        JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        if (isSelected) {
            setBackground(table.getSelectionBackground());
            textArea.setForeground(table.getSelectionForeground());
        } else {
            setBackground(table.getBackground());
            textArea.setForeground(table.getForeground());
        }

        if (value instanceof UserCellData) {
            UserCellData data = (UserCellData) value;
            
            // Cargar imagen circular
            ImageIcon icon = new ImageIcon(getClass().getResource("assets/images/users" + data.getImageName()));
            Image image = icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(image));

            // Texto nombre + correo
            textArea.setText(data.getName() + "\n" + data.getEmail());
        }

        return this;
    }
    
}

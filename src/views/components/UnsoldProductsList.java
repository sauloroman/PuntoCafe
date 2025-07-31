package views.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;

public class UnsoldProductsList {

    public static JPanel create(List<String> unsoldProducts) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(500, 350));
        panel.setBackground(Color.WHITE);

        JList<String> productList = new JList<>(unsoldProducts.toArray(new String[0]));
        productList.setFont(new Font("SansSerif", Font.PLAIN, 12));
        productList.setForeground(Color.RED);
        productList.setFixedCellHeight(24);
        productList.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(productList);
        scrollPane.setPreferredSize(new Dimension(500, 350));

        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }
}

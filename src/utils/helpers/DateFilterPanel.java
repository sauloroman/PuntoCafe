package utils.helpers;

import com.toedter.calendar.JDateChooser;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DateFilterPanel {
    
    private final JPanel panelStart;
    private final JPanel panelEnd;
    
    private final JDateChooser dateChooserStart;
    private final JDateChooser dateChooserEnd;
    
    public DateFilterPanel(JPanel panelStart, JPanel panelEnd) {
        this.panelStart = panelStart;
        this.panelEnd = panelEnd;
        
        this.dateChooserStart = new JDateChooser();
        this.dateChooserEnd = new JDateChooser();
        
        setupPanel(this.panelStart, "Inicio:", dateChooserStart);
        setupPanel(this.panelEnd, "Fin:", dateChooserEnd);
        
        dateChooserStart.setDate(new Date());
        dateChooserEnd.setDate(new Date());
    }
    
    private void setupPanel(JPanel targetPanel, String labelText, JDateChooser chooser) {
        targetPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        chooser.setPreferredSize(new Dimension(140, 25));

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("SansSerif", Font.PLAIN, 11));

        targetPanel.add(label);
        targetPanel.add(chooser);
        targetPanel.revalidate();
        targetPanel.repaint();
    }
    
    public Date getStartDate() {
        return dateChooserStart.getDate();
    }

    public Date getEndDate() {
        return dateChooserEnd.getDate();
    }

    public void setStartDate(Date date) {
        dateChooserStart.setDate(date);
    }

    public void setEndDate(Date date) {
        dateChooserEnd.setDate(date);
    }
}

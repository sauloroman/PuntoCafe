package views.components;

import javax.swing.*;
import java.awt.*;

public class SplashScreen extends JDialog {

    private final JProgressBar progressBar;

    public SplashScreen(Frame parent) {
        super(parent, false);
        setUndecorated(true);
        setSize(300, 150);
        setLocationRelativeTo(null);

        progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);

        JLabel label = new JLabel("Cargando PuntoCafé...", SwingConstants.CENTER);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(label, BorderLayout.CENTER);
        getContentPane().add(progressBar, BorderLayout.SOUTH);
    }
}

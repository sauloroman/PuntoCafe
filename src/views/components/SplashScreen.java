package views.components;

import javax.swing.*;
import java.awt.*;

public class SplashScreen extends JDialog {

    private final JProgressBar progressBar;
    private final ImageCustom imageCustom = new ImageCustom();

    public SplashScreen(Frame parent) {
        super(parent, false);
        setUndecorated(true);
        setSize(300, 180);
        setLocationRelativeTo(null);

        progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);

        JLabel label = new JLabel("", SwingConstants.CENTER);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        imageCustom.addImageFixNoCache(label, "loading", 300, 180);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(label, BorderLayout.CENTER);
        getContentPane().add(progressBar, BorderLayout.SOUTH);
    }
}

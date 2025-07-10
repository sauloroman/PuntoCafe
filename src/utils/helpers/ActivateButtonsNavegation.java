package utils.helpers;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import utils.constants.ViewConstants;

public final class ActivateButtonsNavegation {

    public static void activateBtn( JButton btn ) {
        btn.setBackground(Color.decode(ViewConstants.menuActiveBtn));
        btn.setFont( new Font("sansserif", Font.BOLD, 12 ) );
        btn.setForeground(Color.WHITE);
    }
    
    public static void deactivateBtn( JButton btn ) {
        btn.setBackground(Color.decode(ViewConstants.menuDeactiveBtn));
        btn.setFont( new Font("sansserif", Font.PLAIN, 12 ) );
        btn.setForeground(Color.decode(ViewConstants.textBtn));
    }
}

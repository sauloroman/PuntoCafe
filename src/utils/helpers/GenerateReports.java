package utils.helpers;

import config.Database;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class GenerateReports {
    
    public static void generateReport(String reportName, String title) {
        Map p = new HashMap();
        JasperReport report;
        JasperPrint print;
        
        Database cnn = Database.getInstance();
        
        try {
            report = JasperCompileManager.compileReport(new File("").getAbsolutePath() + "/src/reports/" + reportName + ".jrxml");
            print = JasperFillManager.fillReport(report, p, cnn.connect());
            JasperViewer view = new JasperViewer(print, false);
            view.setTitle(title);
            view.setVisible(true);
        } catch(JRException e) {
            System.out.println("Error al crear el reporte " + e.getMessage());
        }
    }
    
}

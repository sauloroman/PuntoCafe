package utils.helpers;

import config.Database;
import java.io.File;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class GenerateReports {

    public static void generateReport(String reportName, String title) {
        generateReport(reportName, title, null);
    }

    public static void generateReport(String reportName, String title, Map<String, Object> parameters) {
    JasperReport report;
    JasperPrint print;

    Database cnn = Database.getInstance();

    try {
        // Ruta base absoluta
        String reportsPath = new File("").getAbsolutePath() + "/src/reports/";
        System.out.println("Reports Path: " + reportsPath);
        
        // Asegúrate de que el mapa no sea null
        if (parameters == null) {
            parameters = new java.util.HashMap<>();
        }

        // Agrega la ruta de los subreportes como parámetro
        parameters.put("SUBREPORT_DIR", reportsPath);
        
        String path = reportsPath + reportName + ".jrxml";
        report = JasperCompileManager.compileReport(path);
        print = JasperFillManager.fillReport(report, parameters, cnn.connect());
        JasperViewer view = new JasperViewer(print, false);
        view.setTitle(title);
        view.setVisible(true);
    } catch (JRException e) {
        System.out.println("Error al crear el reporte: " + e.getMessage());
    }
}

}

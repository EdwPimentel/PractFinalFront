package com.regedw.PractFinalFront.servicios;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class ReporteService {JasperPrint generarReportePrestamoRaw(CompraServices compraServices) throws JRException {

    //Cargando el reporte desde la carpeta recurso.
    String path = "/reportes/prestamo.jasper";
    JasperReport reporte = (JasperReport) JRLoader.loadObject(this.getClass().getResourceAsStream(path));

    //Parametros.
    HashMap<String, Object> parametros = new HashMap<>();

    CompraJRDataSource p = new CompraJRDataSource(compraServices);
    //Mandando a ejecutar el proyecto.
    JasperPrint print = JasperFillManager.fillReport(reporte, parametros, p);

    return print;
}

    /**
     * @param jasperPrint
     * @return
     */
    FileInputStream convertirReporteaPdf(JasperPrint jasperPrint) {
        File archivoTemp = null;
        try {
            archivoTemp = File.createTempFile("gec_", ".pdf");
            byte[] archivoArreglo = JasperExportManager.exportReportToPdf(jasperPrint);
            Path path = Files.write(archivoTemp.toPath(), archivoArreglo);
            return new FileInputStream(archivoTemp);
        } catch (IOException | JRException e) {
            e.printStackTrace();
        }
        return null;
    }

    public FileInputStream generarReportePrestamoPdf(CompraServices compraServices) {
        try {
            return convertirReporteaPdf(generarReportePrestamoRaw(compraServices));
        } catch (JRException e) {
            e.printStackTrace();
        }
        return null;
    }

}

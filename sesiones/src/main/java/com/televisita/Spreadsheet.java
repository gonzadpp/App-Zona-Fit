package com.televisita;

import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Spreadsheet {

    static final String[] tableHeader = {"ID","FECHA","HORA","DURACIÓN (MINUTOS)","TERMINAL VISITAS","TERMINAL PPL","ESTATUS"};
    static final String sheetName = "Sesiones";

    static void createTableSession(ArrayList<Sesion> sessions, String fileName) {

        System.out.println("Generando archivo XLSX ...");

        try(XSSFWorkbook workBook = new XSSFWorkbook()) {
            XSSFSheet sheet = workBook.createSheet(sheetName);
            int rowIndex = 0;
            XSSFRow row = sheet.createRow(rowIndex);
            //Iteración para generar el encabelzado de la tabla en la fila con indice 0.
            for (int i = 0; i < tableHeader.length; i++) {
                String columnTitle = tableHeader[i];
                XSSFCell cell = row.createCell(i);
                cell.setCellValue(columnTitle);
            }
            rowIndex++;
            for (int i = 0; i < sessions.size(); i++) {
                row = sheet.createRow(rowIndex);
                Sesion sesion = sessions.get(i);
                row.createCell(0).setCellValue(sesion.getIdSesion());
                row.createCell(1).setCellValue(sesion.getFechaSesion());
                row.createCell(2).setCellValue(sesion.getHoraSesion());
                row.createCell(3).setCellValue(sesion.getDuracionSesion());
                row.createCell(4).setCellValue(sesion.getTerminalVisita());
                row.createCell(5).setCellValue(sesion.getTerminalPPL());
                row.createCell(6).setCellValue(sesion.getEstatusSesion());
                rowIndex++;
            }
            //Guardamos el archivo generado.
            FileOutputStream fileOutput = new FileOutputStream(fileName);     
            workBook.write(fileOutput);
            fileOutput.close();
            System.out.println("Archivo generado correctamente.");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error al generar archivo XLSX ...");
        }

    }

}
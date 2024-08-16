package com.televisita;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * App para filtrar y clasificar datos de las sesiones de televisita.
 */
public class App 
{
    static final String regex = ".*[.]txt$"; //Expresion regular para validar que el archivo termine en .txt  
    static GetData getData; 

    public static void main( String[] args ) throws Exception
    {
        System.out.println("Generador de Reportes de Televisita");

        boolean response = false;
        do {
            System.out.println("Ingrese la ruta del archivo .txt");
            try (Scanner sc = new Scanner(System.in)) {
                String pathString = sc.nextLine();

                Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(pathString);

                if (matcher.find()) {
                    getData = new GetData();
                    getData.readFile(pathString);
                    break;
                } else {
                    System.out.println("Requiere ingresar un archivo con extención .txt");
                }
            }
        } while (response != true);
        
    }
}
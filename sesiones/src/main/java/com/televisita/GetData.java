package com.televisita;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

 public class GetData {
    // expresiones regulares ID | FECHA | HORA | DURACION
    private final String dataRegex[] = { "(^\\d{4,6})\\sPublic", "(\\d{4}-\\d{1,2}-\\d{1,2})",
            "(\\d{1,2}:\\d{1,2}\\s\\w{2}\\s\\w{3})", "CDT\\s(60|55|50|45|40|35|30|25|20|15|10|5)\\s",
            "(Perdido|Terminado|Llamada perdida la persona que llama|Cancelado por el administrador|Cancelled|Interrumpido)", // ESTATUS DE LA SESSION
            "NIP:.*((MN|CPS|Marina).*T\\d{3,4}$)", // TERMINAL VISITAS
            "(PX\\d{3}|PPL\\d{3}|PPLN\\d{2,3}|A\\d{4,5}\\w{2,3}).*(PPL|Visitas)\\s(CPS.*T\\d{3,4}$)" }; // TERMINAL PPL
    private String[] televisitaSession = new String[7];
    private ArrayList<Sesion> sessions = new ArrayList<>();

    /* Metodo para leer el archivo */
    void readFile(String file) {
        try (FileReader fr = new FileReader(file)) {
            BufferedReader br = new BufferedReader(fr);
            // Lectura del fichero
            String line;
            int j = 0;
            /* Para encontrar las lineas que contengan las palabras clave por ejemplo: "Visita", "PPL", "Marina Nacional" y "CPS13"
                Se usa el metodo de expresiones regulares.*/
            while ((line = br.readLine()) != null) {
                for (int i = 0; i < dataRegex.length; i++) {
                    Pattern pattern = Pattern.compile(dataRegex[i], Pattern.CASE_INSENSITIVE);
                    Matcher matcher = pattern.matcher(line);
                    // Toma la linea de texto y busca las 7 expresiones regulares
                    if (matcher.find()) { // Si alguna expresion regular hace match
                        if (i >= 0 && i < 6) {
                            televisitaSession[i] = matcher.group(1); // Agrega el fragmento del texto que coincide a un
                        }
                        if (i == 6) {
                            televisitaSession[i] = matcher.group(3);
                        }
                        j++; // Contador
                        if (j == 7) { // Cuando el contador llega a 7 el array se a completado con los datos de la sesion y se imprime.
                            sessions.add(new Sesion(televisitaSession[0], televisitaSession[1], televisitaSession[2], televisitaSession[3], televisitaSession[5], televisitaSession[6], televisitaSession[4]));
                            j = 0; // Se reinicia el conteo.
                            Arrays.fill(televisitaSession, null);
                        }
                    }
                }
            }
            showArrayListSession();
            System.out.println("  ");
            System.out.println("Número de sesiones encontradas: " + sessions.size() + " sesiones de televista");
            Spreadsheet.createTableSession(sessions,"Sesiones Televisita.xlsx");
        } catch (Exception e) { 
            e.printStackTrace();
        }
    }

    private void showArrayListSession() {
        for (Sesion session : sessions) {
            System.out.println(session.toString());
        }
    }
}

package com.Prc;

// Librerias

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Project_1 {
    // RAMA 1
    public static final String SEPARATOR = ",";

    //Ana Schleissner - metodo leer el CSV
    public static void leerCSV(Datos[] datos_array) throws IOException {

        BufferedReader br = null;
        int contador = 0;
        for (int i = 0; i < 18025; i++) {
            datos_array[i] = new Datos();
        }

        try {

            br = new BufferedReader(new FileReader(".\\electronic_card_transactions.csv"));
            String line = br.readLine();

            while (line != null) {
                String[] fields = line.split(SEPARATOR);
                if (contador != 0) {
                    datos_array[contador].setSeries_reference(fields[0]);
                    datos_array[contador].setPeriod(format.parse(fields[1]));
                    try{
                        datos_array[contador].setData_value(Float.parseFloat(fields[2]));
                    } catch (Exception e2){
                        datos_array[contador].setData_value(0);
                    }
                    datos_array[contador].setStatus(fields[4].charAt(0));
                    datos_array[contador].setUnits(fields[5]);
                    datos_array[contador].setSubject(fields[6]);
                    datos_array[contador].setGroup(fields[7]);
                    datos_array[contador].setSeries_title_1(fields[8]);
                    datos_array[contador].setSeries_title_2(fields[10]);

                }

                contador++;
                line = br.readLine();
            }

        } catch (Exception e) {

        } finally {
            if (null != br) {
                br.close();
            }
        }
    }

    // Hugo Hernandez - metodo guardar en CSV
    private static void guardarCSV(Datos[] datos_csv) throws IOException {
        String[] valores = new String[18025];
        int contador = 0;
        String archCSV = ".\\salida.csv";
        CSVWriter writer = new CSVWriter(new FileWriter(archCSV));

        for (int i = 0; i < datos_csv.length; i++) {
            if ("Credit".equals(datos_csv[i].getSeries_title_2())) {
                valores[contador] = String.valueOf(datos_csv[i].getData_value());
                contador++;
            }

        }

        writer.writeNext(valores);
        writer.close();

        System.out.println("Archivo .csv generado");
    }

    public static void main(String[] args) {

    }
}


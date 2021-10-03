package com.Prc;

// Librerias

import com.opencsv.CSVWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.util.Scanner;


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
    //Jose Roma - Buscar Operación
    public static void buscarOperacion(Datos[] datos_array) throws ParseException {
        SimpleDateFormat formato_fecha = new SimpleDateFormat("yyyy.MM");
        String fecha_inicial;
        String mes;
        String anio;

        do{
            lector.nextLine();

            System.out.println("Introduzca la fecha: mm/YYYY"); // 04/2001
            fecha_inicial = lector.nextLine();
            mes = fecha_inicial.substring(0,2);
            anio = fecha_inicial.substring(3);
            if(fecha_inicial.length() != 7 || fecha_inicial.charAt(2) != '/' ||  (Integer.parseInt(mes) < 0 || Integer.parseInt(mes) > 13) || (Integer.parseInt(anio) < 0 || (Integer.parseInt(anio) > 2022))){
                System.out.println("Introduzca una fecha valida");
            }

        }while(fecha_inicial.length() != 7 || fecha_inicial.charAt(2) != '/' ||  (Integer.parseInt(mes) < 0 || Integer.parseInt(mes) > 13) || (Integer.parseInt(anio) < 0 || (Integer.parseInt(anio) > 2022)));

        String fecha = anio + "." + mes;
        Date fecha_final = format.parse(fecha);

        float suma = 0;
        for(int i = 0; i < datos_array.length; i++){
            if(fecha_final.equals(datos_array[i].getPeriod())){
                suma = suma + datos_array[i].getData_value();
            }
        }

        System.out.println("La suma final es de: " + suma + "$");


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

    // Carmela Regife - Main
    public static void main(String[] args) {

        Datos[] datos_csv = new Datos[18025];
        leerCSV(datos_csv);

        int eleccion = 0;
        do{
            System.out.println("==========================================================");
            System.out.println("Elija una opcion");
            System.out.println("1.- Buscar operacion por fecha");
            System.out.println("2.- Mostrar entradas entre 1000 y 10000 ");
            System.out.println("3.- Guardar");
            System.out.println("4.- Salir");
            System.out.println("==========================================================");

            try{
                eleccion = lector.nextInt();
            }catch (Exception e){
                System.out.println("Introduzca un caracter valido");

            }

            switch (eleccion){
                case 1:
                   // buscarOperacion(datos_csv);
                    break;
                case 2:
                   // mostrarEntradas(datos_csv);
                    break;
                case 3:
                    guardarCSV(datos_csv);
                    break;
                case 4:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Introduzca un numero entre 1 y 4. Gracias.");
                    break;
            }
        }while(eleccion != 4);


    }



}
}


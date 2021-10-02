
// Hugo Hernandez - metodo guardar en CSV
private static void guardarCSV(Datos[] datos_csv) throws IOException {
        String[] valores = new String[18025];
        int contador = 0;
        String archCSV = ".\\salida.csv";
        CSVWriter writer = new CSVWriter(new FileWriter(archCSV));

        for(int i = 0; i < datos_csv.length; i++){
        if("Credit".equals(datos_csv[i].getSeries_title_2())){
        valores[contador] = String.valueOf(datos_csv[i].getData_value());
        contador++;
        }

        }

        writer.writeNext(valores);
        writer.close();

        System.out.println("Archivo .csv generado");
        }

public static void main(String[]args){

}


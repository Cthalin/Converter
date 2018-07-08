package csvToJson;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class Converter {

    StringBuilder result = new StringBuilder("[");

    public static void main(String[] args) throws Exception {
        Converter c = new Converter();
        File file = new File(String.valueOf(c.getDefaultPath()));
        c.convertCsv(file);
    }

    private void convertCsv(File file) throws IOException {
        BufferedReader csvFile = new BufferedReader(new FileReader(file));
        BufferedWriter jsonFile = new BufferedWriter(new FileWriter("converted.txt"));

        String fileContent = csvFile.readLine();
        String[] header = fileContent.split(";");

        while (fileContent !=null){
            fileContent=csvFile.readLine();
            if (fileContent != null){
                String[] tab = fileContent.split(";");
                result.append("{");
                for(int i=0; i<tab.length;i++){
                    result.append("\""+header[i]+"\":\""+tab[i]+"\",");
                    if(i==tab.length-1){
                        result.setLength(result.length()-1);
                        result.append("},");
                    }
                }
            }
        }
        result.setLength(result.length()-1);
        result.append("]");
        System.out.println(result.toString());
        jsonFile.write(result.toString());
        csvFile.close();
        jsonFile.close();
    }

    private Path getDefaultPath(){
        Path path = FileSystems.getDefault().getPath("src", "csvToJson", "users.csv");
        return path;
    }
}
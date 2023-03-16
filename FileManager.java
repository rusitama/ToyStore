
import java.io.*;

public class FileManager {
    public static String loadFromFile(String filename){
        File file = new File(filename);
        StringBuilder result = new StringBuilder();
        if (file.exists()){
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
                String line;
                while ((line = reader.readLine()) != null){
                    result.append(line);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }            
        }
        return result.toString();
    }

    public static void writeToFile(String filename, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))){
            writer.write(data);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

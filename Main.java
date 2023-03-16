import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        loadFromFile("toys.txt"); 
        writeToFile("toys.txt", "hello");       
    }

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
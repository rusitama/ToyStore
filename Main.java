/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        FileManager.loadFromFile("toys.txt"); 
        FileManager.writeToFile("toys.txt", "hello");       
    }

    
}
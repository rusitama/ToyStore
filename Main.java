/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        ToyManager toyManager = new ToyManager();
        toyManager.loadToysFromFile("toys.txt");

        //FileManager.readFromFile("toys.txt"); 
        //FileManager.writeToFile("toys.txt", "hello");       
    }

    
}
import java.util.ArrayList;
import java.util.List;

public class ToyManager {

    private List<Toy> toys = new ArrayList<>();

    public void loadToysFromFile(String fileName) {
        String data = FileManager.readFromFile(fileName);
        String[] lines = data.split("\n");
        for (String line : lines) {
            String[] fields = line.split(",");
            if (fields.length != 1){
            int id = Integer.parseInt(fields[0]);
            String name = fields[1];
            int quantity = Integer.parseInt(fields[2]);
            double weight = Double.parseDouble(fields[3]);
            Toy toy = new Toy(id, name, quantity, weight);
            toys.add(toy);
            }
        }
    }
}

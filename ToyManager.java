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

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void updateToyWeight(int id, double weight) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setWeight(weight);
                return;
            }
        }
    }

    public Toy choosePrizeToy() {
        double totalWeight = toys.stream().mapToDouble(Toy::getWeight).sum();
        double randomNumber = Math.random() * totalWeight;
        double currentWeight = 0;
        for (Toy toy : toys) {
            currentWeight += toy.getWeight();
            if (currentWeight >= randomNumber) {
                if (toy.getQuantity() > 0) {
                    toy.setQuantity(toy.getQuantity() - 1);
                    toys.remove(toy);
                    return toy;
                }
            }
        }
        return null;
    }

    public void saveToysToFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        for (Toy toy : toys) {
            sb.append(toy.getId()).append(",").append(toy.getName()).append(",").append(toy.getQuantity()).append(",").append(toy.getWeight()).append("\n");
        }
        FileManager.writeToFile(fileName, sb.toString());
    }
}

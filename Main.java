/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        ToyManager toyManager = new ToyManager();
        toyManager.loadToysFromFile("toys.txt");

        // добавляем новые игрушки
        toyManager.addToy(new Toy(1, "Boll", 10, 10));
        toyManager.addToy(new Toy(2, "Toy", 5, 20));
        toyManager.addToy(new Toy(3, "Teddy bear", 7, 15));

        // изменяем вес игрушек
        toyManager.updateToyWeight(1, 30);
        toyManager.updateToyWeight(2, 50);
        toyManager.updateToyWeight(3, 20);

         // выбираем призовую игрушку
         Toy prizeToy = toyManager.choosePrizeToy();

         if (prizeToy != null) {
            // сохраняем призовую игрушку в файл
            FileManager.writeToFile("prize.txt", prizeToy.getName());

            // сохраняем изменения в файл
            toyManager.saveToysToFile("toys.txt");
        } else {
            System.out.println("No prize toys available.");
        }
        //FileManager.readFromFile("toys.txt"); 
        //FileManager.writeToFile("toys.txt", "hello");       
    }

    
}
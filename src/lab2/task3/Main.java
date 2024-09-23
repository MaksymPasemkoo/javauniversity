package lab2.task3;

public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        Item item1 = new Item("TV", 50, 30, 10);
        Item item2 = new Item("Fridge", 60, 70, 80);
        Item item3 = new Item("Laptop", 15, 10, 1);
        Item item4 = new Item("Washing Machine", 60, 80, 90);
        Item item5 = new Item("Oven", 61, 60, 65);
        Item item6 = new Item("Microwave", 20, 15, 15);

        Bin bin1 = new Bin(55, 35, 15);
        Bin bin2 = new Bin(65, 75, 85);
        Bin bin3 = new Bin(20, 15, 5);
        Bin bin4 = new Bin(70, 85, 95);
        Bin bin5 = new Bin(61, 65, 70);
        Bin bin6 = new Bin(25, 20, 20);


        try {
            warehouse.addItem(item1,bin1);
            warehouse.addItem(item2,bin2);
            warehouse.addItem(item3,bin3);
            warehouse.addItem(item4,bin4);
            warehouse.addItem(item5,bin5);
//            warehouse.addItem(item6,bin6);

            warehouse.getItems();

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }
}


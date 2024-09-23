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

        Item item7 = new Item("Cap", 20, 15, 15);
        Item item8 = new Item("Phone", 20, 15, 15);
        Item item9 = new Item("Charge", 20, 15, 15);

        Bin bin1 = new Bin(61, 80, 90);
        Bin bin2 = new Bin(65, 75, 85);



        try {
            warehouse.addItem(item1,bin1);
            warehouse.addItem(item2,bin1);
            warehouse.addItem(item3,bin1);
            warehouse.addItem(item4,bin1);
            warehouse.addItem(item5,bin1);
//            warehouse.addItem(item6,bin1);

            warehouse.addItem(item7,bin2);
            warehouse.addItem(item8,bin2);
            warehouse.addItem(item9,bin2);
            warehouse.getItems();

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }
}


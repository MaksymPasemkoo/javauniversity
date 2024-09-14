package lab2.task3;



public class Main {
    public static void main(String[] args) {
            WarehouseManagement warehouse = new WarehouseManagement(10);

            Item item1 = new Item("Item1", 1);
            Item item2 = new Item("Item2", 2);
            Item item3 = new Item("Item3", 5);
            Item item4 = new Item("Item4", 1);
            Item item5 = new Item("Item5", 4);
            Item item6 = new Item("Item6", 6);



        try {
            warehouse.addItem(item1);
            warehouse.addItem(item2);
            warehouse.addItem(item3);
            warehouse.addItem(item4);
            warehouse.addItem(item5);
//            warehouse.addItem(item6);

            warehouse.getItems();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

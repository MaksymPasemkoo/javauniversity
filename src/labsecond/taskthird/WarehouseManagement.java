package labsecond.taskthird;


public class WarehouseManagement {
    private final Item[] items;
    private final int MAX_CAPACITY = 5;

    private final int storageDemission;
    private int itemCount;

    public WarehouseManagement(int storageDemission) {
        this.items = new Item[MAX_CAPACITY];
        this.storageDemission = storageDemission;
    }

    public void addItem(final Item item) throws Exception {
        if(itemCount >= MAX_CAPACITY){
            throw new Exception("You reached maximum capacity.");
        }
        if(item.getSizeOfItem() > storageDemission){
            throw new Exception("Not enough space to contain " + item.getName());
        }
        items[itemCount++] = item;
    }

    public void getItems() {
        if(itemCount == 0) return;
        System.out.println("Items in warehouse:");
        for (Item item : items) {
            if (item == null){
                continue;
            }
            System.out.println(item);
        }
    }
}

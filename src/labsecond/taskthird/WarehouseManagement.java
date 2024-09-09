package labsecond.taskthird;

import java.util.ArrayList;
import java.util.List;

public class WarehouseManagement {
    private final List<Item> items;

    public WarehouseManagement(List<Item> itemList) {
        this.items = new ArrayList<>();
    }

    public void addItem(final Item item) throws Exception {
        if(items.size() > item.getMaxCapacity()){
            throw new Exception("You reached maximum capacity.");
        }
        items.add(item);
    }

    public List<Item> getItems() {
        if(items.isEmpty()) return items;
        return items;
    }
}

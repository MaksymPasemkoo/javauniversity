package labsecond.taskthird;

public class Item {
    private final String name;
    private final int sizeOfItem;
    private final int maxCapacity = 5;

    public Item(String name, int sizeOfItem) {
        this.name = name;
        this.sizeOfItem = sizeOfItem;
    }

    public String getName() {
        return name;
    }

    public int getSizeOfItem() {
        return sizeOfItem;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", sizeOfItem=" + sizeOfItem +
                ", maxCapacity=" + maxCapacity +
                '}';
    }
}

package labsecond.taskthird;

public class Item {
    private final String name;
    private final int sizeOfItem;

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


    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", sizeOfItem=" + sizeOfItem +
                '}';
    }
}

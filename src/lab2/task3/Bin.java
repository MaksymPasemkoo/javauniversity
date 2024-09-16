package lab2.task3;

public class Bin {
    private final int width;
    private final int height;
    private final int length;
    private final Item[] items;
    private int itemCount;
    private final int MAX_CAPACITY = 5;


    public Bin(int width, int height, int length) {
        this.width = width;
        this.height = height;
        this.length = length;
        this.items = new Item[MAX_CAPACITY];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public void setItem(Item item){
        items[itemCount++] = item;
    }

    public Item[] getItems() {
        return items;
    }
}

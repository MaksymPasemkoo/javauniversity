package lab2.task3;

public class Bin {
    private final int width;
    private final int height;
    private final int length;
    private final int MAX_CAPACITY = 5;
    private final Item[] items = new Item[MAX_CAPACITY];
    private int itemCount;

    public Bin(int width, int height, int length) {
        this.width = width;
        this.height = height;
        this.length = length;
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

    public int getMAX_CAPACITY() {
        return MAX_CAPACITY;
    }

    public int getItemCount() {
        return itemCount;
    }
}

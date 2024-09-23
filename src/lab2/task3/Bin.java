package lab2.task3;

public class Bin {
    private final int width;
    private final int height;
    private final int length;
    private static final int MAX_CAPACITY = 5;
    private static final Item[] items = new Item[MAX_CAPACITY];
    private static int itemCount;



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

    public static void setItem(Item item){
        items[itemCount++] = item;
    }

    public static Item[] getItems() {
        return items;
    }
}

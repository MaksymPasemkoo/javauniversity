package lab2.task3;

public class Bin {
    private final int width;
    private final int height;
    private final int length;
    private final Item item;

    public Bin(int width, int height, int length,Item item) {
        this.width = width;
        this.height = height;
        this.length = length;
        this.item = item;
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

    public Item getItem() {
        return item;
    }

}

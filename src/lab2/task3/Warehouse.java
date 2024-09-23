package lab2.task3;


public class Warehouse {
    private final Bin[] bins;
    private final int MAX_CAPACITY = 5;
    private int binCount;

    public Warehouse(){
        this.bins = new Bin[MAX_CAPACITY];
    }

    public void addItem(final Item item,final Bin bin){
        if(binCount >= MAX_CAPACITY){
            throw new RuntimeException("You reached maximum capacity.");
        }

        if(item.getWidth() > bin.getWidth() || item.getHeight() > bin.getHeight()
                || item.getLength() > bin.getLength()){
            throw new RuntimeException("Not enough space to contain " + item.getName());
        }
        bins[binCount++] = bin;
        Bin.setItem(item);
    }

    public void getItems() {
        if(binCount == 0) return;
        System.out.println("Items in warehouse:");
        for (Item item : Bin.getItems()) {
            if (item != null) {
                System.out.println(item);
            }
        }
    }

}

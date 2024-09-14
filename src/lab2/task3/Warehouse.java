package lab2.task3;


public class Warehouse {
    private final Bin[] bins;
    private final int MAX_CAPACITY = 5;
    private int binCount;

    public Warehouse(){
        this.bins = new Bin[MAX_CAPACITY];
    }

    public void addItem(final Bin bin){
        if(binCount >= MAX_CAPACITY){
            throw new RuntimeException("You reached maximum capacity.");
        }
        if(bin.getItem().getWidth() > bin.getWidth() || bin.getItem().getHeight() > bin.getHeight()
                || bin.getItem().getLength() > bin.getLength()){
            throw new RuntimeException("Not enough space to contain " + bin.getItem().getName());
        }
        bins[binCount++] = bin;
    }

    public void getItems() {
        if(binCount == 0) return;
        System.out.println("Items in warehouse:");
        for (Bin bin : bins) {
            if (bin.getItem() == null){
                continue;
            }
            System.out.println(bin.getItem());
        }
    }


}

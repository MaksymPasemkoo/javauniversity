package lab2.task3;


import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private final List<Bin> bins;

    public Warehouse(){
        bins = new ArrayList<>();
    }

    public void addItem(final Item item,final Bin bin){
        if(bin.getItemCount() >= bin.getMAX_CAPACITY()){
            throw new RuntimeException("You reached maximum capacity.");
        }

        if(item.getWidth() > bin.getWidth() || item.getHeight() > bin.getHeight()
                || item.getLength() > bin.getLength()){
            throw new RuntimeException("Not enough space to contain " + item.getName());
        }
        if(!bins.contains(bin)) {
            bins.add(bin);
        }
        bin.setItem(item);
    }

    public void getItems() {
        if(bins.isEmpty()) return;
        System.out.println("Items in warehouse:");
        for (Bin bin : bins) {
            for (Item item : bin.getItems()) {
                if(item != null) {
                    System.out.println(item);
                }
            }
        }
    }

}

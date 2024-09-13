package practice.composition;

public class Phone {
    private Cpu cpu;


    public Phone() {
        this.cpu = new Cpu();
    }
}

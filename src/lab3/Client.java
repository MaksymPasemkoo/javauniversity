package lab3;

public class Client {
    private final String name;
    private final long passwordId;
    private double balance;


    public Client(String name, long passwordId, double balance) {
        this.name = name;
        this.passwordId = passwordId;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public long getPasswordId() {
        return passwordId;
    }

    public double getBalance() {
        return balance;
    }

    public void decrementBalance(double balance) {
        this.balance -= balance;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", passwordId=" + passwordId +
                ", balance=" + balance +
                '}';
    }
}

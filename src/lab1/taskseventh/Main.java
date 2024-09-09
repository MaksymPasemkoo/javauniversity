package lab1.taskseventh;

public class Main {
    public static void main(String[] args) {
        Bank bank1 = new Bank("MonoBank");
        Bank bank2 = new Bank("Privat 24");

        bank1.addExchangeRate("USD", 1.0);
        bank1.addExchangeRate("EUR", 0.9);
        bank2.addExchangeRate("USD", 1.0);
        bank2.addExchangeRate("EUR", 0.85);

        BankAccount account1 = new BankAccount("42341", bank1, "USD", "Carl"
                , 1000);
        BankAccount account2 = new BankAccount("78902", bank1, "EUR", "Alice"
                , 500);
        BankAccount account3 = new BankAccount("92985", bank2, "USD", "Bob"
                , 800);

        account1.transferTo(account2, 200);

        account1.transferTo(account3, 100);
    }
}


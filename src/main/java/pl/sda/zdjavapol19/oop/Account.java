package pl.sda.zdjavapol19.oop;

public class Account {

    private String id, name;
    private int balance;    //=0

    public Account(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public int credit(int amount) {
        this.balance += amount;
        return this.balance;
    }

    public int debit(int amount) {
        if(amount <= this.balance) {
            this.balance -= amount;
        }
        else {
            System.out.println("Amount exceeded balance.");
        }
        return this.balance;
    }

    public int transferTo(Account target, int amount) {
        if(amount <= this.balance) {
            this.balance -= amount;
            target.credit(amount);
        }
        else {
            System.out.println("Cannot transfer money: amount exceeded balance.");
        }
        return this.balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }
}

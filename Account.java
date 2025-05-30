public class Account {
    private final String accountNumber;
    private double balance;
    private final User user;

    public Account(String accountNumber, double balance, User user) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.user = user;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public User getUser() {
        return user;
    }
}

import java.util.Date;

public class Transaction {
    private final Date date;
    private final double amount;
    private final Account account;
    private final String type; // deposit or withdraw

    public Transaction(Date date, double amount, Account account, String type) {
        this.date = date;
        this.amount = amount;
        this.account = account;
        this.type = type;
    }

    public void execute() {
        System.out.println("Transaction type: " + type + ", Amount: " + amount);
        if ("deposit".equalsIgnoreCase(type)) {
            account.deposit(amount);
        } else if ("withdraw".equalsIgnoreCase(type)) {
            account.withdraw(amount);
        } else {
            System.out.println("Invalid transaction type.");
        }
    }
}

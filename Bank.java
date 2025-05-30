 import java.util.List;

public class Bank {
    private final String name;
    private final List<Account> accounts;

    public Bank(String name, List<Account> accounts) {
        this.name = name;
        this.accounts = accounts;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}

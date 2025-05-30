 import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user = new User("Alice", "123 Main Street");
        Account account = new Account("ACC123", 500.0, user);
        Card card = new Card("CARD123", "1234");
        
        List<Account> accountList = new ArrayList<>();
        accountList.add(account);
        Bank bank = new Bank("National Bank", accountList);
        ATM atm = new ATM("Downtown", bank);

        atm.authenticateCard(card);

        Transaction deposit = new Transaction(new Date(), 200.0, account, "deposit");
        atm.performTransaction(deposit);

        Transaction withdrawal = new Transaction(new Date(), 100.0, account, "withdraw");
        atm.performTransaction(withdrawal);
    }
}

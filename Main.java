import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Create a new user
        User user = new User("Alice", "123 Main Street");

        // Create a new account for the user with an initial balance
        Account account = new Account("ACC123", 500.0, user);

        // Create a card with PIN
        Card card = new Card("CARD123", "1234");

        // Add the account to a list of accounts
        List<Account> accountList = new ArrayList<>();
        accountList.add(account);

        // Create a bank with the list of accounts
        Bank bank = new Bank("National Bank", accountList);

        // Create an ATM linked to the bank
        ATM atm = new ATM("Downtown", bank);

        // Authenticate user via card and PIN
        try ( // Set up scanner to read user input
                Scanner scanner = new Scanner(System.in)) {
            // Authenticate user via card and PIN
            atm.authenticateCard(card);
            // Start ATM interaction loop
            while (true) {
                // Show menu options
                System.out.println("\n--- ATM Menu ---");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("0. Exit");
                System.out.print("Choose option: ");
                
                int choice = scanner.nextInt(); // Read menu choice
                
                if (choice == 0) {
                    // Exit the program
                    System.out.println("Thank you for using the ATM.");
                    break;
                }
                
                if (choice == 3) {
                    // Show current account balance
                    System.out.println("Current balance: $" + account.getBalance());
                    continue; // Go back to menu
                }
                
                // Read amount for deposit or withdrawal
                System.out.print("Enter amount: ");
                double amount = scanner.nextDouble();
                
                // Perform the transaction based on choice (no unused variable here!)
                switch (choice) {
                    case 1 -> // Deposit transaction
                        atm.performTransaction(new Transaction(new Date(), amount, account, "deposit"));
                    case 2 -> // Withdraw transaction
                        atm.performTransaction(new Transaction(new Date(), amount, account, "withdraw"));
                    default -> // Invalid menu choice
                        System.out.println("Invalid option. Try again.");
                }
            }
            // Close scanner after exiting loop
        }
    }
}

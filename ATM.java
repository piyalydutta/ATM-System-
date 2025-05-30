import java.util.Scanner;

public class ATM {
    private final String location;
    private final Bank bank;

    public ATM(String location, Bank bank) {
        this.location = location;
        this.bank = bank;
    }

    public void authenticateCard(Card card) {
        System.out.println("Enter PIN for card " + card.getCardNumber() + ":");
        Scanner scanner = new Scanner(System.in);
        String inputPin = scanner.nextLine();
        if (card.getPin().equals(inputPin)) {
            System.out.println("Card authenticated successfully.");
        } else {
            System.out.println("Invalid PIN.");
        }
    }

    public void performTransaction(Transaction transaction) {
        transaction.execute();
    }
}

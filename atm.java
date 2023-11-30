import java.util.Scanner;

public class atm {
    private double balance;
    private int pin;

    public atm(double initialBalance, int pin) {
        this.balance = initialBalance;
        this.pin = pin;
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw Cash");
        System.out.println("3. Deposit Cash");
        System.out.println("4. Exit");
    }

    public void checkBalance() {
        System.out.println("Current Balance: $" + balance);
    }

    public void withdrawCash(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal Successful. Remaining Balance: $" + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    public void depositCash(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit Successful. New Balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public static void main(String[] args) {
        atm Atm = new atm(1000.0, 1234); // Initial balance and PIN

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM!");
        System.out.print("Enter your PIN: ");
        int enteredPin = scanner.nextInt();

        if (enteredPin == Atm.pin) {
            int choice;
            do {
                Atm.displayMenu();
                System.out.print("Enter your choice (1-4): ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        Atm.checkBalance();
                        break;
                    case 2:
                        System.out.print("Enter withdrawal amount: $");
                        double withdrawalAmount = scanner.nextDouble();
                        Atm.withdrawCash(withdrawalAmount);
                        break;
                    case 3:
                        System.out.print("Enter deposit amount: $");
                        double depositAmount = scanner.nextDouble();
                        Atm.depositCash(depositAmount);
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                }
            } while (choice != 4);
        } else {
            System.out.println("Invalid PIN. Exiting...");
        }

        scanner.close();
    }
}
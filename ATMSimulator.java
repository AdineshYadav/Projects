package Task2;

import java.util.Scanner;

public class ATMSimulator {
    private double balance;

    public ATMSimulator() {
        this.balance = 0.0;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public void transfer(double amount, ATMSimulator targetAccount) {
        if (balance >= amount) {
            balance -= amount;
            targetAccount.deposit(amount);
            System.out.println("Transferred: $" + amount);
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATMSimulator atm = new ATMSimulator();

        while (true) {
            System.out.println("ATM Simulator Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: $" + atm.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.print("Enter transfer amount: $");
                    double transferAmount = scanner.nextDouble();
                    System.out.print("Enter target account balance: $");
                    double targetBalance = scanner.nextDouble();
                    ATMSimulator targetAccount = new ATMSimulator();
                    targetAccount.deposit(targetBalance);
                    atm.transfer(transferAmount, targetAccount);
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

package ws2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("Welcome to Bank!");
        System.out.println("Create your Bank Account. Enter your name: ");
        
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        System.out.println("How much is your initial deposit?");
        float initialDeposit = Float.parseFloat(scanner.nextLine());

        BankAccount bankaccount = new BankAccount(name, initialDeposit);

        LocalDateTime creationDate = (LocalDateTime.now());
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedCreationDate = creationDate.format(dateTimeFormatter);
        bankaccount.setCreationDate(formattedCreationDate);

        System.out.println("Account name is " + bankaccount.getAccountName());
        System.out.println("Account balance is " + bankaccount.getAccountBalance());
        System.out.println("Bank Account creation at " + bankaccount.getCreationDate());

        boolean stopLoop = false;

        while (!stopLoop) {
            System.out.println("What do you want to do?");

            String function = scanner.next();
            function = function.trim();

            String amount = scanner.nextLine();
            amount = amount.trim();

            switch (function) {
                case "deposit":
                    try {
                        bankaccount.deposit(Float.parseFloat(amount));
                    } catch (NumberFormatException nfe) {
                        System.out.println("Enter a valid amount.");
                    }
                    break;
                case "withdraw":
                try {
                    bankaccount.withdraw(Float.parseFloat(amount));
                } catch (NumberFormatException nfe) {
                    System.out.println("Enter a valid amount.");
                }
                    break;
                case "close":
                    bankaccount.close();
                    System.out.println("Your account has been closed as of " + bankaccount.getClosureDate());
                    stopLoop = true;
                    break;
                default:
                    System.out.println("Invalid Function. Available Functions: deposit, withdraw, close.");
            }

        }
        System.out.println(bankaccount.getTransactionHistory());

        System.out.println("Welcome to Bank!");
        System.out.println("Create your Fixed Deposit Account. Enter your name: ");
        name = scanner.nextLine();

        System.out.println("How much is your initial deposit?");
        initialDeposit = Float.parseFloat(scanner.nextLine());

        System.out.println("What interest would you like your FD Account to have?");
        float interest = Float.parseFloat(scanner.nextLine());

        FixedDepositAccount fDAccount = new FixedDepositAccount(name, initialDeposit, interest);

        creationDate = (LocalDateTime.now());
        dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        formattedCreationDate = creationDate.format(dateTimeFormatter);
        fDAccount.setCreationDate(formattedCreationDate);

        System.out.println("Account name is " + fDAccount.getAccountName());
        System.out.println("Account balance is " + initialDeposit);
        System.out.println("Account interest is " + fDAccount.getInterest());
        System.out.println("Duration in Months: " + fDAccount.getDurationInMonths());
        System.out.println("Fixed Deposit Account creation at " + fDAccount.getCreationDate());


        stopLoop = false;

        while (!stopLoop) {
            System.out.println("What do you want to do?");

            String function = scanner.next();
            function = function.trim();

            String amount = scanner.nextLine();
            amount = amount.trim();

            switch (function) {
                case "deposit":
                    try {
                        fDAccount.deposit(Float.parseFloat(amount));
                    } catch (NumberFormatException nfe) {
                        System.out.println("Enter a valid amount.");
                    }
                    break;
                case "withdraw":
                try {
                    fDAccount.withdraw(Float.parseFloat(amount));
                } catch (NumberFormatException nfe) {
                    System.out.println("Enter a valid amount.");
                }
                    break;
                case "close":
                    fDAccount.close();
                    System.out.println("Your account has been closed as of " + fDAccount.getClosureDate());
                    stopLoop = true;
                    break;
                default:
                    System.out.println("Invalid Function. Available Functions: deposit, withdraw, close.");
            }

        }
        System.out.println("Your balance for your Fixed Deposit Account after tenure is " + fDAccount.getAccountBalance());

    }
}
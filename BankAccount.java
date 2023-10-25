package ws2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BankAccount {
    
    private String accountName;
    private String accountNumber;
    private float accountBalance;
    private ArrayList<String> transactionHistory = new ArrayList<>();
    private boolean isAccountClosed;
    private String creationDate;
    private String closureDate;

    //TODO constructors x2
    // 2 parameters = accountName, accountBalance
    public BankAccount(String accountName, float accountBalance) {
        this.accountName = accountName;
        this.accountBalance = accountBalance;
    }
    
    // 1 parameter = accountName
    public BankAccount(String accountName) {
        this(accountName, 0);
    }

    //TODO methods
    // deposit 
    // - add to transactionHistory
    // - only positive amount accepted
    // - 0 or negative amount or account closed -> IllegalArgumentException

    public void deposit(float amount) {
        if (amount > 0) {
            LocalDateTime depositDate = (LocalDateTime.now());
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String formattedDepositDate = depositDate.format(dateTimeFormatter);
            transactionHistory.add("Deposit " + amount + " at " + formattedDepositDate);
            accountBalance += amount;
            System.out.println("Account Balance: " + accountBalance);
        } else {
            throw new IllegalArgumentException("Deposit cannot be a negative amount.");
        }
    }

    // withdraw
    // - add to transactionHistory
    // - positive && only enough to withdraw accepted
    // - not enough to withdraw || account closed -> IllegalArgumentException

    public void withdraw(float amount) {
        if (amount < 0 || accountBalance - amount >= 0) {
            LocalDateTime withdrawalDate = (LocalDateTime.now());
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String formattedWithdrawalDate = withdrawalDate.format(dateTimeFormatter);
            transactionHistory.add("Withdraw " + amount + " at " + formattedWithdrawalDate);
            System.out.println("Account Balance: " + accountBalance);
        } else {
            throw new IllegalArgumentException("Invalid Withdrawal Amount. Either negative withdraw amount or balance is less than withdrawal amount.");
        }
    }

    // close
    // - isAccountClosed = true
    // - set closureDate

    public void close() {
        LocalDateTime closureDate = (LocalDateTime.now());
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedClosureDate = closureDate.format(dateTimeFormatter);
        isAccountClosed = true;
        setClosureDate(formattedClosureDate);
    }

    //TODO getters && setters
    // accountName = getter only; cannot be changed
    public String getAccountName() {
        return accountName;
    }
    // accountNumber = getter only; cannot be changed
    public String getAccountNumber() {
        return accountNumber;
    }
    // accountBalance = getter and setters
    public float getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }
    // transactionHistory = getter and setters

    public ArrayList<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(ArrayList<String> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }
    // isAccountClosed = getter and setters

    public boolean getIsAccountClosed() {
        return isAccountClosed;
    }

    public void setIsAccountClosed(boolean isAccountClosed) {
        this.isAccountClosed = isAccountClosed;
    }
    // creationDate = getter and setters

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
    // closureDate = getter and setters

    public String getClosureDate() {
        return closureDate;
    }

    public void setClosureDate(String closureDate) {
        this.closureDate = closureDate;
    }
}
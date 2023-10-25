package ws2;

public class FixedDepositAccount extends BankAccount{
    // inherit BankAccount

    // TODO members
    // interest float
    // durationInMonths integer (default 3 && 6)
    private float interest;
    private int durationInMonths;

    // TODO constructors
    public FixedDepositAccount(String accountName, float accountBalance, 
                float interest, int durationInMonths) {
        super(accountName, accountBalance);
        this.interest = interest;
        this.durationInMonths = durationInMonths;
    }
    
    public FixedDepositAccount(String accountName, float accountBalance, 
                float interest) {
        this(accountName, accountBalance, interest, 6);
    }

    public FixedDepositAccount(String accountName, float accountBalance) {
        this(accountName, accountBalance, 3, 6);
    }

    // TODO methods
    // @Override withdraw = cannot update
    @Override
    public void withdraw(float amount) {
        System.out.println("Cannot withdraw.");
    }
    // @Override deposit = cannot update
    @Override
    public void deposit(float amount) {
        System.out.println("Cannot deposit.");
    }

    // TODO getters && setters
    // interest = getter and setters; changed only once (if is 3); throw IllegalArgumentException
    
    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        if (interest == 3) {
            this.interest = interest;
        } else {
            throw new IllegalArgumentException("Cannot set interest.");
        }
    }

    // durationInMonths = getter and setters; changed only once (if is 6); throw IllegalArgumentException

    public int getDurationInMonths() {
        return durationInMonths;
    }

    public void setDurationInMonths(int durationInMonths) {
        if (durationInMonths == 6) {
            this.durationInMonths = durationInMonths;
        } else {
            throw new IllegalArgumentException();
        }
    }

    // @Override accountBalance setter = cannot be changed
    
    @Override
    public void setAccountBalance(float accountBalance) {
        System.out.println("Account Balance cannot be changed.");
    }

    // @Override accountBalance getter = balance + interest
    @Override
    public float getAccountBalance() {
        return super.getAccountBalance() + interest;
    }

}
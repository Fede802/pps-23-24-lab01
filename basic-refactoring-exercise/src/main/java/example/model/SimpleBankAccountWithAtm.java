package example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account allows always the deposit
 * while the withdrawal is allowed only if the balance greater or equal the withdrawal amount
 */
public class SimpleBankAccountWithAtm implements BankAccountWithAtm {

    private final static int FEE = 1;

    private final SimpleBankAccount simpleBankAccount;

    public SimpleBankAccountWithAtm(AccountHolder holder, double balance) {
        this.simpleBankAccount = new SimpleBankAccount(holder, balance);
    }

    @Override
    public AccountHolder getHolder() {
        return this.simpleBankAccount.getHolder();
    }

    @Override
    public double getBalance() {
        return this.simpleBankAccount.getBalance();
    }

    @Override
    public void deposit(int userID, double amount) {
        double taxedAmount = amount - FEE;
        this.simpleBankAccount.deposit(userID, taxedAmount);
    }
    @Override
    public void withdraw(int userID, double amount) {
        double taxedAmount = amount + FEE;
        this.simpleBankAccount.withdraw(userID, taxedAmount);
    }


}

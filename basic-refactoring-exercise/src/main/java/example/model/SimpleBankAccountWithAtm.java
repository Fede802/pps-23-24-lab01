package example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account allows always the deposit
 * while the withdrawal is allowed only if the balance greater or equal the withdrawal amount
 */
public class SimpleBankAccountWithAtm extends SimpleBankAccount {

    //better use composition -> use a private SimpleBankAccount field
    private final static int FEE = 1;


    public SimpleBankAccountWithAtm(AccountHolder holder, double balance) {
        super(holder, balance);
    }

    @Override
    public void deposit(int userID, double amount) {
        double taxedAmount = amount - FEE;
        super.deposit(userID, taxedAmount);
    }
    @Override
    public void withdraw(int userID, double amount) {
        double taxedAmount = amount + FEE;
        super.withdraw(userID, taxedAmount);
    }


}

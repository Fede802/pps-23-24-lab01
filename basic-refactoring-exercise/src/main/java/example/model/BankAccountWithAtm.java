package example.model;

public interface BankAccountWithAtm extends BankAccount {

    /**
     * Allows the deposit of an amount on the account, if the given userID corresponds to the register holder ID
     * of the bank account. This ID acts like an "identification token" .
     * Is present a 1$ fee
     *
     * @param userID the id of the user that wants do the deposit
     * @param amount the amount of the deposit
     */
    @Override
    void deposit(int userID, double amount);

    /**
     * Allows the withdrawal of an amount from the account, if the given userID corresponds to the register holder ID
     * of the bank account. This ID acts like an "identification token" .
     * Is present a 1$ fee
     *
     * @param userID the id of the user that wants do the withdrawal
     * @param amount the amount of the withdrawal
     */
    @Override
    void withdraw(int userID, double amount);
}

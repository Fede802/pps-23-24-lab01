import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.BankAccountWithAtm;
import example.model.SimpleBankAccountWithAtm;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountWithAtmTest{

    private final static int INITIAL_AMOUNT = 100;
    private final static int FEE = 1;
    private BankAccountWithAtm bankAccount;

    @BeforeEach
    void beforeEach(){
        AccountHolder accountHolder = new AccountHolder("Mario", "Rossi", 1);
        this.bankAccount = new SimpleBankAccountWithAtm(accountHolder, 0);
    }

    @Test
    void testInitialBalance() {
        assertEquals(0, this.bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        AccountHolder accountHolder = this.bankAccount.getHolder();
        this.bankAccount.deposit(accountHolder.getId(), INITIAL_AMOUNT);
        double taxedAmount = INITIAL_AMOUNT-FEE;
        assertEquals(taxedAmount, this.bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        AccountHolder accountHolder = this.bankAccount.getHolder();
        this.bankAccount.deposit(accountHolder.getId(), INITIAL_AMOUNT);
        double taxedAmount = INITIAL_AMOUNT-FEE;
        double amountToWithdraw = 70;
        this.bankAccount.withdraw(accountHolder.getId(), amountToWithdraw);
        taxedAmount = taxedAmount-amountToWithdraw-FEE;
        assertEquals(taxedAmount, this.bankAccount.getBalance());
    }


}

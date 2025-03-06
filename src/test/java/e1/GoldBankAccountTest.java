package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GoldBankAccountTest extends BankAccountTest {

    @Test
    public void testCanWithdraw() {
        this.account.deposit(1000);
        this.account.withdraw(200);
        assertEquals(799, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.account.deposit(1000);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(1200));
    }

    @Override
    protected BankAccount createAccount() {
        return new GoldBankAccount(new CoreBankAccount());
    }
}

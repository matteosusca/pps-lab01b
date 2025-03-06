package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GoldBankAccountTest extends BankAccountTest {

    @Test
    public void testCanWithdraw() {
        this.account.deposit(1000);
        this.account.withdraw(200);
        assertEquals(800, this.account.getBalance());
    }

    @Test
    public void testCanWithdrawMoreThanAvailable(){
        this.account.deposit(1000);
        assertDoesNotThrow(() -> this.account.withdraw(1200));
    }

    @Test
    public void testOverdraftLimitExceeded() {
        this.account.deposit(1000);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(1601));
    }

    @Override
    protected BankAccount createAccount() {
        return new GoldBankAccount(new CoreBankAccount());
    }
}

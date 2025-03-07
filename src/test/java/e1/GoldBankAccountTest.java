package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GoldBankAccountTest extends BankAccountTest {

    @Test
    public void testCanWithdraw() {
        this.account.deposit(STANDARD_DEPOSIT);
        this.account.withdraw(STANDARD_WITHDRAW);
        assertEquals(STANDARD_DEPOSIT - STANDARD_WITHDRAW, this.account.getBalance());
    }

    @Test
    public void testCanWithdrawMoreThanAvailable(){
        this.account.deposit(STANDARD_DEPOSIT);
        assertDoesNotThrow(() -> this.account.withdraw(STANDARD_DEPOSIT + (GoldBankAccount.OVERDRAFT_LIMIT - 1)));
    }

    @Test
    public void testOverdraftLimitExceeded() {
        this.account.deposit(STANDARD_DEPOSIT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(STANDARD_DEPOSIT + (GoldBankAccount.OVERDRAFT_LIMIT + 1)));
    }

    @Override
    protected BankAccount createAccount() {
        return new GoldBankAccount(new CoreBankAccount());
    }
}

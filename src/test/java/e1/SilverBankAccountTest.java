package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SilverBankAccountTest extends BankAccountTest {


    @Test
    public void testCanWithdraw() {
        this.account.deposit(STANDARD_DEPOSIT);
        this.account.withdraw(STANDARD_WITHDRAW);
        assertEquals(STANDARD_DEPOSIT - (STANDARD_WITHDRAW + SilverBankAccount.FEE), this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.account.deposit(STANDARD_DEPOSIT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(STANDARD_DEPOSIT + 1));
    }

    @Override
    protected BankAccount createAccount() {
        return new SilverBankAccount(new CoreBankAccount());
    }
}

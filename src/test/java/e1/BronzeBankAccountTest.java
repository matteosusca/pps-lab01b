package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BronzeBankAccountTest extends BankAccountTest {

    public static final int NO_FEE_WITHDRAWAL = BronzeBankAccount.THRESHOLD - 1;

    @Override
    protected BankAccount createAccount() {
        return new BronzeBankAccount(new CoreBankAccount());
    }

    @Test
    public void testCanWithdrawNoFee() {
        this.account.deposit(STANDARD_DEPOSIT);
        this.account.withdraw(NO_FEE_WITHDRAWAL);
        assertEquals(STANDARD_DEPOSIT - NO_FEE_WITHDRAWAL, this.account.getBalance());
    }

    @Test
    public void testFeeLargeWithdrawal() {
        this.account.deposit(STANDARD_DEPOSIT);
        this.account.withdraw(STANDARD_WITHDRAW);
        assertEquals(STANDARD_DEPOSIT - (STANDARD_WITHDRAW + BronzeBankAccount.FEE), this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable() {
        this.account.deposit(STANDARD_DEPOSIT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(STANDARD_DEPOSIT + 1));
    }
}

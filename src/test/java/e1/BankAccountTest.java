package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class BankAccountTest {

    public static final int STANDARD_DEPOSIT = 1000;
    public static final int STANDARD_WITHDRAW = 200;
    protected BankAccount account;

    protected abstract BankAccount createAccount();

    @BeforeEach
    void init(){
        this.account = createAccount();
    }

    @Test
    public void testInitiallyEmpty() {
        assertEquals(0, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.account.deposit(STANDARD_DEPOSIT);
        assertEquals(STANDARD_DEPOSIT, this.account.getBalance());
    }
}

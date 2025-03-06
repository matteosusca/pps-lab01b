package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class BankAccountTestBrutto {

    private final Supplier<BankAccount> supplier;
    protected BankAccount account;

    public BankAccountTestBrutto(Supplier<BankAccount> supplier) {
        this.supplier = supplier;
        this.account = this.supplier.get();
    }

    @BeforeEach
    void init(){
        this.account = supplier.get();
    }

    @Test
    public void testInitiallyEmpty() {
        assertEquals(0, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.account.deposit(1000);
        assertEquals(1000, this.account.getBalance());
    }
}

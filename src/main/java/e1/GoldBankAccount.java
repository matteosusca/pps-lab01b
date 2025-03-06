package e1;

public class GoldBankAccount implements BankAccount {

    private final BankAccount base;

    public GoldBankAccount(BankAccount base) {
        this.base = base;
    }

    @Override
    public int getBalance() {
        return base.getBalance();
    }

    @Override
    public void deposit(int amount) {
        base.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {

    }
}

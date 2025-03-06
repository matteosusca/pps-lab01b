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
        if (base.getBalance() - amount < -500) {
            throw new IllegalStateException("Overdraft limit exceeded");
        }
        base.withdraw(amount);
    }
}

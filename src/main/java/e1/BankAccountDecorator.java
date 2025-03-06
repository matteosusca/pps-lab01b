package e1;

public class BankAccountDecorator implements BankAccount{

    protected final BankAccount decoratedAccount;

    public BankAccountDecorator(BankAccount decoratedAccount) {
        this.decoratedAccount = decoratedAccount;
    }

    @Override
    public int getBalance() {
        return decoratedAccount.getBalance();
    }

    @Override
    public void deposit(int amount) {
        decoratedAccount.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        decoratedAccount.withdraw(amount);
    }
}

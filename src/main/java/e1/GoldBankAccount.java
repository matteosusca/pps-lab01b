package e1;

public class GoldBankAccount extends BankAccountDecorator {

    public GoldBankAccount(BankAccount decoratedAccount) {
        super(decoratedAccount);
    }

    @Override
    public void withdraw(int amount) {
        if (decoratedAccount.getBalance() - amount < -500) {
            throw new IllegalStateException("Overdraft limit exceeded");
        }
        decoratedAccount.withdraw(amount);
    }
}

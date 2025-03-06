package e1;

public class BronzeBankAccount extends BankAccountDecorator{
    public BronzeBankAccount(BankAccount decoratedAccount) {
        super(decoratedAccount);
    }

    @Override
    public void withdraw(int amount) {
        if (decoratedAccount.getBalance() < amount){
            throw new IllegalStateException();
        }
        if (amount >= 100) {
            decoratedAccount.withdraw(amount + 1);
        } else {
            decoratedAccount.withdraw(amount);
        }
    }
}

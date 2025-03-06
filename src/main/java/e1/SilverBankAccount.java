package e1;

public class SilverBankAccount extends BankAccountDecorator {

    public SilverBankAccount(BankAccount decoratedAccount) {
        super(decoratedAccount);
    }

    @Override
    public void withdraw(int amount) {
        if (decoratedAccount.getBalance() < amount){
            throw new IllegalStateException();
        }
        decoratedAccount.withdraw(amount + 1);
    }
}

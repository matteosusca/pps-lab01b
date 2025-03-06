package e1;

public class SilverBankAccount extends BankAccountDecorator {

    public SilverBankAccount(BankAccount decoratedAccount) {
        super(decoratedAccount, new NoOverdraftPolicy(), new FixedFeePolicy(1));
    }
}

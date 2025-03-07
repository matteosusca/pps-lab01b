package e1;

public class SilverBankAccount extends BankAccountDecorator {

    public static final int FEE = 1;

    public SilverBankAccount(BankAccount decoratedAccount) {
        super(decoratedAccount, new NoOverdraftPolicy(), new FixedFeePolicy(FEE));
    }
}

package e1;

public class BronzeBankAccount extends BankAccountDecorator{
    public static final int FEE = 1;
    public static final int THRESHOLD = 100;

    public BronzeBankAccount(BankAccount decoratedAccount) {
        super(decoratedAccount, new NoOverdraftPolicy(), new ConditionalFeePolicy(FEE, THRESHOLD));
    }
}

package e1;

public class GoldBankAccount extends BankAccountDecorator {

    public static final int OVERDRAFT_LIMIT = 500;
    public static final int FEE = 0;

    public GoldBankAccount(BankAccount decoratedAccount) {
        super(decoratedAccount, new OverdraftPolicy(OVERDRAFT_LIMIT), new FixedFeePolicy(FEE));
    }
}

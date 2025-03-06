package e1;

public class BankAccountDecorator implements BankAccount{

    protected final BankAccount decoratedAccount;
    private final WithdrawalPolicy withdrawalPolicy;
    private final FeePolicy feePolicy;

    public BankAccountDecorator(BankAccount decoratedAccount, WithdrawalPolicy withdrawalPolicy, FeePolicy feePolicy) {
        this.decoratedAccount = decoratedAccount;
        this.withdrawalPolicy = withdrawalPolicy;
        this.feePolicy = feePolicy;
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
        withdrawalPolicy.validateWithdrawal(decoratedAccount.getBalance(), amount);
        int fee = feePolicy.calculateFee(amount);
        decoratedAccount.withdraw(amount + fee);
    }
}

package Items;

public class AccountItem {
    int account_id;
    double balance;

    public AccountItem() {
    }

    public AccountItem(int account_id, double balance) {
        this.account_id = account_id;
        this.balance = balance;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

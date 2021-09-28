package models;

public class CtAItem {
    private int junction_id;
    private int customer_id;
    private int account_id;

    public CtAItem() {}

    public CtAItem(int junction_id, int customer_id, int account_id) {
        this.junction_id = junction_id;
        this.customer_id = customer_id;
        this.account_id = account_id;
    }

    public int getJunction_id() {
        return junction_id;
    }

    public void setJunction_id(int junction_id) {
        this.junction_id = junction_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }
}

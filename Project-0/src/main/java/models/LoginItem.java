package models;

public class LoginItem {
    private int customer_id;
    private String user_name;
    private String password;

    public LoginItem() {}

    public LoginItem(int customer_id, String user_name, String password) {
        this.customer_id = customer_id;
        this.user_name = user_name;
        this.password = password;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package pojo;

import java.io.Serializable;

public class Balance_log implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int balance_log_id;
    private int user_id;
    private String operation_type;
    private String operation_note;
    private double amount;

    public int getBalance_log_id() {
        return balance_log_id;
    }

    public void setBalance_log_id(int balance_log_id) {
        this.balance_log_id = balance_log_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getOperation_type() {
        return operation_type;
    }

    public void setOperation_type(String operation_type) {
        this.operation_type = operation_type;
    }

    public String getOperation_note() {
        return operation_note;
    }

    public void setOperation_note(String operation_note) {
        this.operation_note = operation_note;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

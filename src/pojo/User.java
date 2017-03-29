package pojo;

import java.sql.Timestamp;

public class User {
    private int user_id;
    private String user_name;
    private String user_password;
    private int user_type;
    private String user_email;
    private Timestamp register_time;
    private Timestamp sign_time;
    private String sign_ip;
    private double balance;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public int getUser_type() {
        return user_type;
    }

    public void setUser_type(int user_type) {
        this.user_type = user_type;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public Timestamp getRegister_time() {
        return register_time;
    }

    public void setRegister_time(Timestamp register_time) {
        this.register_time = register_time;
    }

    public Timestamp getSign_time() {
        return sign_time;
    }

    public void setSign_time(Timestamp sign_time) {
        this.sign_time = sign_time;
    }

    public String getSign_ip() {
        return sign_ip;
    }

    public void setSign_ip(String sign_ip) {
        this.sign_ip = sign_ip;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

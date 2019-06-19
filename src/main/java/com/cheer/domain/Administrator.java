package com.cheer.domain;

public class Administrator {
    private  String accountName;
    private  String password;

    public Administrator() {
    }

    public Administrator(String accountName, String password) {
        this.accountName = accountName;
        this.password = password;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "accountName='" + accountName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

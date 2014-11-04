package com.snail.controllers.test.model;

/**
 * User: jinchao.xu
 * Date: 14-10-23
 * Time: 上午10:58
 */
public class Account {
    private int id;
    private String name;
    private double accountNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(double accountNumber) {
        this.accountNumber = accountNumber;
    }
}

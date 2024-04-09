package org.sopt.domain;

public class Account {
    private String accountNumber; // 계좌 번호
    private String owner; // 고객
    private Integer balance; // 잔액
    public Account(String accountNumber, String owner, Integer balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = 0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public Integer getBalance() {
        return balance;
    }
}

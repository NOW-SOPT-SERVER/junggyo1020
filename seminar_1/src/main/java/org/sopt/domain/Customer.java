package org.sopt.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name; // 고객 이름
    private String id; // 고객 식별 번호
    private List<Account> accounts = new ArrayList<>(); // 고객이 소유한 계좌의 목록

    public Customer(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
    public List<Account> getAccounts() {
        return accounts;
    }
}

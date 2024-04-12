package org.sopt.service;

import org.sopt.domain.BankAccount;
import org.sopt.error.ErrorMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// 은행 계좌 관련 서비스를 제공하는 클래스입니다.
public class BankingService {
    private final List<BankAccount> accounts; // 계좌 정보를 저장하는 리스트

    public BankingService() {
        this.accounts = new ArrayList<>();
        // 예시 계좌 2개를 기본적으로 추가합니다.
        accounts.add(new BankAccount("123456-78-123456", 10000));
        accounts.add(new BankAccount("987654-32-987654", 20000));
    }

    // 계좌 번호로 계좌를 찾는 메서드
    private BankAccount findAccountByAcctNumber(String acctNumber) {
        return accounts.stream()
                .filter(acct -> acct.getAcctNumber().equals(acctNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.ACCOUNT_NOT_FOUND.getMessage()));
    }

    // 계좌 생성 메서드
    public String createNewAccount(){
        String newAccountNumber = generateNewAccountNumber();
        BankAccount newAccount = new BankAccount(newAccountNumber, 0); // 초기 잔액은 0
        accounts.add(newAccount);
        return newAccountNumber;
    }

    // 새 계좌 번호 생성 메서드
    private String generateNewAccountNumber() {
        Random random = new Random();
        return String.format("%06d-%02d-%06d", random.nextInt(1000000), random.nextInt(100), random.nextInt(1000000));
    }

    // 입금 메서드
    public void depositToAccount(String acctNumber, Integer amount) {
        BankAccount account = findAccountByAcctNumber(acctNumber);
        account.addFunds(amount);
    }

    // 출금 메서드
    public void withdrawFromAccount(String acctNumber, Integer amount) {
        BankAccount account = findAccountByAcctNumber(acctNumber);
        account.subtractFunds(amount);
    }

    // 이체 메서드
    public void transferFunds(String fromAcctNumber, String toAcctNumber, Integer amount) {
        BankAccount fromAccount = findAccountByAcctNumber(fromAcctNumber);
        BankAccount toAccount = findAccountByAcctNumber(toAcctNumber);
        if (fromAccount.getAcctBalance() < amount) {
            throw new IllegalArgumentException(ErrorMessage.LOW_BALANCE.getMessage());
        }
        fromAccount.subtractFunds(amount);
        toAccount.addFunds(amount);
    }

    // 잔액 조회 메서드
    public Integer checkAccountBalance(String acctNumber) {
        BankAccount account = findAccountByAcctNumber(acctNumber);
        return account.getAcctBalance();
    }
}

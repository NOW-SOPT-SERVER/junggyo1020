package org.sopt.domain;

import org.sopt.error.ErrorMessage;

// 은행 계좌 정보를 관리하는 클래스입니다.
public class BankAccount {
    private String acctNumber; // 계좌번호
    private Integer acctBalance; // 잔액

    // 계좌 생성자, 계좌번호와 초기 잔액을 입력받아 초기화합니다.
    public BankAccount(String acctNumber, Integer initialBalance) {
        // 초기 잔액이 null이거나 음수일 경우 예외를 발생시킵니다.
        if (initialBalance == null || initialBalance < 0) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_INITIAL_BALANCE.getMessage());
        }
        this.acctNumber = acctNumber; // 입력받은 계좌번호로 계좌번호를 초기화합니다.
        this.acctBalance = initialBalance; // 입력받은 초기 잔액으로 잔액을 초기화합니다.
    }

    // 입금 메서드. 입금할 금액을 입력받아 잔액을 증가시킵니다.
    public void addFunds(Integer amount) {
        // 입금 금액이 null이거나 0 이하일 경우 예외를 발생시킵니다.
        if (amount == null || amount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DEPOSIT.getMessage());
        }
        this.acctBalance += amount; // 잔액에 입금 금액을 더합니다.
    }

    // 출금 메서드. 출금할 금액을 입력받아 잔액을 감소시킵니다.
    public void subtractFunds(Integer amount) {
        // 출금 금액이 null이거나 0 이하, 또는 잔액보다 많을 경우 예외를 발생시킵니다.
        if (amount == null || amount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WITHDRAWAL.getMessage());
        }
        if (this.acctBalance < amount) {
            throw new IllegalArgumentException(ErrorMessage.LOW_BALANCE.getMessage());
        }
        this.acctBalance -= amount; // 잔액에서 출금 금액을 뺍니다.
    }

    // 계좌번호를 반환하는 메서드입니다.
    public String getAcctNumber() {
        return acctNumber;
    }

    // 현재 잔액을 반환하는 메서드입니다.
    public Integer getAcctBalance() {
        return acctBalance;
    }
}

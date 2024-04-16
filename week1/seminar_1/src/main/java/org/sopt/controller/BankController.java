package org.sopt.controller;

import org.sopt.service.BankingService;
import org.sopt.view.InputView;
import org.sopt.view.OutputView;

// 은행 서비스에 대한 사용자 요청을 처리하는 컨트롤러
public class BankController {
    private final BankingService bankService;
    private final InputView inputView;
    private final OutputView outputView;

    // 생성자
    public BankController() {
        this.bankService = new BankingService();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    // 은행 서비스 시작 메서드
    public void start() {
        boolean active = true;
        while (active) {
            int choice = inputView.getUserOption();
            try {
                switch (choice) {
                    case 0:
                        executeCreateAccount();
                        break;
                    case 1:
                        executeDeposit();
                        break;
                    case 2:
                        executeWithdrawal();
                        break;
                    case 3:
                        executeTransfer();
                        break;
                    case 4:
                        executeBalanceCheck();
                        break;
                    case 5:
                        active = false;
                        outputView.displayMessage("서비스를 종료합니다.");
                        break;
                    default:
                        outputView.displayErrorMessage("올바르지 않은 선택입니다.");
                }
            } catch (IllegalArgumentException e) {
                outputView.displayErrorMessage(e.getMessage());
            }
        }
    }


    // 계좌 생성 처리 로직
    private void executeCreateAccount() {
        String newAccountNumber = bankService.createNewAccount();
        outputView.displayMessage("새 계좌가 생성되었습니다. 계좌 번호: " + newAccountNumber);
    }

    // 입금 처리 로직
    private void executeDeposit() {
        String acctNum = inputView.getAccountNumber();
        int amount = inputView.getAmount();
        bankService.depositToAccount(acctNum, amount);
        outputView.displaySuccessMessage("입금 완료", amount);
    }

    // 출금 처리 로직
    private void executeWithdrawal() {
        String acctNum = inputView.getAccountNumber();
        int amount = inputView.getAmount();
        bankService.withdrawFromAccount(acctNum, amount);
        outputView.displaySuccessMessage("출금 완료", amount);
    }

    // 이체 처리 로직
    private void executeTransfer() {
        String fromAcctNum = inputView.getAccountNumber();
        String toAcctNum = inputView.getTransferAccountNumber();
        int amount = inputView.getAmount();
        bankService.transferFunds(fromAcctNum, toAcctNum, amount);
        outputView.displaySuccessMessage("이체 완료", amount);
    }

    // 잔액 조회 로직
    private void executeBalanceCheck() {
        String acctNum = inputView.getAccountNumber();
        int balance = bankService.checkAccountBalance(acctNum);
        outputView.displayBalance(balance);
    }
}

package org.sopt.view;

public class OutputView {

    public void displayBalance(int balance) {
        System.out.printf("현재 잔액은 %d원입니다.\n", balance);
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displaySuccessMessage(String operation, int amount) {
        System.out.printf("%s 완료: %d원이 처리되었습니다.\n", operation, amount);
    }

    public void displayErrorMessage(String message) {
        System.out.println("오류: " + message);
    }
}

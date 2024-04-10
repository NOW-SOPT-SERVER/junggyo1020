package org.sopt.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public int getUserOption() {
        System.out.println("\n[은행 시스템 메뉴]");
        System.out.println("0. 계좌 생성하기");
        System.out.println("1. 입금하기");
        System.out.println("2. 출금하기");
        System.out.println("3. 계좌 이체");
        System.out.println("4. 잔액 조회");
        System.out.println("5. 종료하기");
        System.out.print("옵션을 선택해주세요: ");
        while (!scanner.hasNextInt()) {
            scanner.next(); // 숫자가 아닌 입력을 받았을 때, 버퍼를 비우고 다시 입력받음
            System.out.print("유효한 숫자를 입력해주세요: ");
        }
        return scanner.nextInt();
    }

    public String getAccountNumber() {
        System.out.print("계좌 번호를 입력해주세요: ");
        return scanner.next();
    }

    public String getTransferAccountNumber(){
        System.out.println("이체 받을 계좌 번호를 입력해주세요: ");
        return scanner.next();
    }

    public int getAmount() {
        System.out.print("금액을 입력해주세요: ");
        while (!scanner.hasNextInt()) {
            scanner.next(); // 숫자가 아닌 입력을 받았을 때, 버퍼를 비우고 다시 입력받음
            System.out.print("유효한 금액을 입력해주세요: ");
        }
        return scanner.nextInt();
    }
}

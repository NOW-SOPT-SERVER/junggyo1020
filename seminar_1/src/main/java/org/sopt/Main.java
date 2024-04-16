package org.sopt;

import org.sopt.controller.BankController;

// 은행 애플리케이션의 메인 클래스
public class Main {
    public static void main(String[] args) {
        // 은행 컨트롤러 객체 생성
        BankController bankController = new BankController();

        // 은행 시스템 시작
        System.out.println("** SOPT BANK - 1차 세미나 실습과제_은행 프로그램을 설계하기 **");
        System.out.println("** made by Jung Junggyo **");
        System.out.println("** 은행 프로그램을 시작합니다. **");

        bankController.start();
    }
}

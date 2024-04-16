package org.sopt.error;

public enum ErrorMessage {
    NEGATIVE_INITIAL_BALANCE("초기 잔액은 음수일 수 없습니다."),
    INVALID_DEPOSIT("입금액이 유효하지 않습니다."),
    INVALID_WITHDRAWAL("출금액이 유효하지 않습니다."),
    LOW_BALANCE("잔액이 부족합니다."),
    INVALID_ACCOUNT_NUMBER("계좌 번호가 유효하지 않습니다."),
    ACCOUNT_NOT_FOUND("계좌를 찾을 수 없습니다."),
    INVALID_OPTION("선택한 옵션이 유효하지 않습니다."),
    INVALID_AMOUNT("입력한 금액이 유효하지 않습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

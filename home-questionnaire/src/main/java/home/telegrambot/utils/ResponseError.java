package home.telegrambot.utils;

public class ResponseError {

    private String code;

    private String message;

    public ResponseError() {
    }

    public ResponseError(String code, String message) {
        this.code = code;
        this.message = message;
    }


}

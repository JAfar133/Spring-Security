package net.golovach.firstspringsecurityapp.util;

public class APIErrorResponse {
    private String message;
    private int codeError;

    public APIErrorResponse(String message, int codeError) {
        this.message = message;
        this.codeError = codeError;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCodeError() {
        return codeError;
    }

    public void setCodeError(int codeError) {
        this.codeError = codeError;
    }
}

package ru.edu.springweb.errorhandler;

public enum ErrorDescription {

    NOT_FOUND(404,"Not found"),
    SYSTEM_UNAVAILABLE(500,"System unavailable");

    private int code;
    private String description;


    ErrorDescription(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}

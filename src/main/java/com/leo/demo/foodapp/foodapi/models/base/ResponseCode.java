package com.leo.demo.foodapp.foodapi.models.base;

/**
 * @author leo
 * @date 2023/1/17
 */
public enum ResponseCode {
    Code_0000("0000", "success"),

    Code_1000("1000","server error");

    /**
     * result code
     */
    private String code;

    /**
     * alert message
     */
    private String message;


    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }


    ResponseCode(String code, String message) {
        this.message = message;
        this.code = code;
    }
}

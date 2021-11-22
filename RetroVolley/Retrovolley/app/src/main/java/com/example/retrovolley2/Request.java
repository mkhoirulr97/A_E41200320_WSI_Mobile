package com.example.retrovolley2;

public class Request {
    private int code;
    private String status;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //method ini berfungsi untuk mengimport jsonrequest
    public static  class Method{
        public static int GET;
    }
}

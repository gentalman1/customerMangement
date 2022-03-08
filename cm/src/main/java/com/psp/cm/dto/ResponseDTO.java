package com.psp.cm.dto;

import org.springframework.http.HttpStatus;

public class ResponseDTO {

    private String message;
    private Object data;
    private Integer status;

    public ResponseDTO() {
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "message='" + message + '\'' +
                ", data=" + data +
                ", status=" + status +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public ResponseDTO(String message, Object data, Integer status) {
        this.message = message;
        this.data = data;
        this.status = status;
    }

    public ResponseDTO(String message, Integer status) {
        this.message = message;
        this.status = status;
    }
}

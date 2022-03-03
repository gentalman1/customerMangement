package com.psp.cm.exception;

import jdk.jfr.Registered;

import javax.validation.constraints.Pattern;
import java.util.Date;

public class ResponseException {

    private String message;
    private Integer status;
    private String error;
    private String path;

    @Pattern(regexp = "yyyy.MM.dd.HH.mm.ss")
    private Date timestamp;

    public ResponseException(String message, Integer status, String error, String path, Date timestamp) {
        this.message = message;
        this.status = status;
        this.error = error;
        this.path = path;
        this.timestamp = timestamp;
    }

    public ResponseException() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}

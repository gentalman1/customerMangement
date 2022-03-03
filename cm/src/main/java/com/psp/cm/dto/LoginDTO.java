package com.psp.cm.dto;

import javax.validation.constraints.NotBlank;

public class LoginDTO {

    @NotBlank(message = "userName must be required!!")
    private String userName;

    @NotBlank(message = "password must be required!!")
    private String password;

    public LoginDTO() {
    }

    public LoginDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginDTO{" + "userName='" + userName + '\'' + ", password='" + password + '\'' + '}';
    }
}

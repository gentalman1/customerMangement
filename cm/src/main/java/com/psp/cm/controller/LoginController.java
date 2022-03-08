package com.psp.cm.controller;

import com.psp.cm.dto.LoginDTO;
import com.psp.cm.service.LoginService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping("auth/")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("login")
    public Object loginProcess(@Valid @RequestBody LoginDTO loginDTO) {
        return loginService.loginProcess(loginDTO);
    }

    @PostMapping("register")
    public Object registerProcess() {
        return null;
    }
}

package com.psp.cm.service;

import com.psp.cm.dto.LoginDTO;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {

    Object loginProcess(LoginDTO loginDTO);
}

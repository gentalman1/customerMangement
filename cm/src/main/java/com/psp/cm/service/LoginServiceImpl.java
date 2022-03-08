package com.psp.cm.service;

import com.psp.cm.common.BaseMethod;
import com.psp.cm.dto.LoginDTO;
import com.psp.cm.dto.ResponseDTO;
import com.psp.cm.entity.UserDetails;
import com.psp.cm.exception.CustomerException;
import com.psp.cm.repository.UserDetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class LoginServiceImpl implements LoginService {

    private final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

    private final UserDetailsRepository userDetailsRepository;

    public LoginServiceImpl(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    @Override
    public Object loginProcess(LoginDTO loginDTO) {
        String email = new String(Base64.getDecoder().decode(loginDTO.getUserName()));
        String password = new String(Base64.getDecoder().decode(loginDTO.getPassword()));
        LOGGER.info("email:::{}", email);
        LOGGER.info("password:::{}", password);
        UserDetails userDetails = userDetailsRepository.findByUserNameOrEmail(email, email);
        if (!BaseMethod.checkNotNull(userDetails))
            throw new CustomerException("user not found!", HttpStatus.NOT_FOUND);
        return ResponseEntity.ok().body(new ResponseDTO("data successfully obtained!", userDetails, HttpStatus.OK.value()));
    }
}

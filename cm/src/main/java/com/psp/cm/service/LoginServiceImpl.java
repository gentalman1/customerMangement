package com.psp.cm.service;

import com.psp.cm.common.BaseMethod;
import com.psp.cm.dto.LoginDTO;
import com.psp.cm.entity.UserDetails;
import com.psp.cm.exception.CustomerException;
import com.psp.cm.repository.UserDetailsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    private final UserDetailsRepository userDetailsRepository;
//    private final Bas

    public LoginServiceImpl(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    @Override
    public Object loginProcess(LoginDTO loginDTO) {
        UserDetails userDetails = userDetailsRepository.findByUserNameOrEmail(loginDTO.getUserName(), loginDTO.getUserName());
        if (!BaseMethod.checkNotNull(userDetails))
            throw new CustomerException("user not found!", HttpStatus.NOT_FOUND);
        return userDetails;
    }
}

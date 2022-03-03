package com.psp.cm.repository;

import com.psp.cm.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {

    UserDetails findByUserNameOrEmail(String userName,String email);
}

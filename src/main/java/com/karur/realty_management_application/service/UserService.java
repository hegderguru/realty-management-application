package com.karur.realty_management_application.service;

import com.karur.realty_management_application.model.read.UserDetail;
import com.karur.realty_management_application.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserEntityRepository userEntityRepository;

    public UserDetail fetchUserDetailByUsername(String username){
        return null;
    }

}

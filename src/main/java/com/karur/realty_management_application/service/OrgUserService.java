package com.karur.realty_management_application.service;

import com.karur.realty_management_application.model.read.UserDetail;
import com.karur.realty_management_application.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class OrgUserService {

    @Autowired
    UserEntityRepository userEntityRepository;

    public Mono<UserDetail> fetchUserDetailByUsername(String username){
        return null;
    }

}

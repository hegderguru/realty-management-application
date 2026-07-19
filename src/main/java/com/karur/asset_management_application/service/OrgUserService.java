package com.karur.asset_management_application.service;

import com.karur.asset_management_application.mapper.EntityToReaderMapper;
import com.karur.asset_management_application.model.read.UserDetail;
import com.karur.asset_management_application.repository.OrganisationUserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrgUserService {

    @Autowired
    OrganisationUserEntityRepository organisationUserEntityRepository;

    @Autowired
    EntityToReaderMapper entityToReaderMapper;

    public UserDetail buildUserDetail(String userName) {
        return entityToReaderMapper.buildUserDetail(organisationUserEntityRepository.fetchByUsername(userName)
                .orElseThrow(() -> new IllegalArgumentException("user not found")));
    }

    public UserDetail buildUserDetail(Long id) {
        return entityToReaderMapper.buildUserDetail(organisationUserEntityRepository.fetchById(id)
                .orElseThrow(() -> new IllegalArgumentException("user not found")));
    }

}

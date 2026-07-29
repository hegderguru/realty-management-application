package com.karur.asset_management_application.service;

import com.karur.asset_management_application.mapper.entityToDetail.EntityToReaderMapper;
import com.karur.asset_management_application.model.read.OrganisationUserDetail;
import com.karur.asset_management_application.repository.OrganisationUserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrgUserService {

    @Autowired
    OrganisationUserEntityRepository organisationUserEntityRepository;

    @Autowired
    EntityToReaderMapper entityToReaderMapper;

    public OrganisationUserDetail buildUserDetail(String userName) {
        return entityToReaderMapper.buildUserDetail(organisationUserEntityRepository.fetchByUsername(userName)
                .orElseThrow(() -> new IllegalArgumentException("user not found")));
    }

    public OrganisationUserDetail buildUserDetail(Long id) {
        return entityToReaderMapper.buildUserDetail(organisationUserEntityRepository.fetchById(id)
                .orElseThrow(() -> new IllegalArgumentException("user not found")));
    }

}

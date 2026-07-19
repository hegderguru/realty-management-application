package com.karur.asset_management_application.service;

import com.karur.asset_management_application.mapper.EntityToReaderMapper;
import com.karur.asset_management_application.model.read.OrganisationDetail;
import com.karur.asset_management_application.repository.OrganisationEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class OrganisationService {

    @Autowired
    OrganisationEntityRepository organisationEntityRepository;

    @Autowired
    EntityToReaderMapper entityToReaderMapper;

    public Mono<OrganisationDetail> fetchById(Long id) {
        return Mono.defer(() -> Mono.just(organisationEntityRepository.fetchById(id)))
                .map(organisationEntity -> entityToReaderMapper.buildOrganisationDetail(organisationEntity));
    }

    public Mono<OrganisationDetail> fetchByNumber(String number) {
        return Mono.defer(() -> Mono.just(organisationEntityRepository.fetchByNumber(number)))
                .map(organisationEntity -> entityToReaderMapper.buildOrganisationDetail(organisationEntity));
    }
}

package com.karur.asset_management_application.service;

import com.karur.asset_management_application.mapper.EntityToReaderMapper;
import com.karur.asset_management_application.model.read.SiteDetail;
import com.karur.asset_management_application.repository.SiteEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class SiteService {

    @Autowired
    SiteEntityRepository siteEntityRepository;

    @Autowired
    EntityToReaderMapper entityToReaderMapper;

    public Mono<SiteDetail> fetchById(Long id){
        return Mono.defer(() -> Mono.just(siteEntityRepository.fetchById(id)))
                .map(siteEntity -> entityToReaderMapper.buildSiteDetail(siteEntity));
    }

    public Mono<SiteDetail> fetchById(String number){
        return Mono.defer(() -> Mono.just(siteEntityRepository.fetchByNumber(number)))
                .map(siteEntity -> entityToReaderMapper.buildSiteDetail(siteEntity));
    }

}

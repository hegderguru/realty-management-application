package com.karur.realty_management_application.repository;

import com.karur.realty_management_application.entity.asset.realty.SiteRealtyAssetEntity;
import com.karur.realty_management_application.repository.inter.ISiteRealtyAssetEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class SiteRealtyAssetEntityRepository {

    @Autowired
    ISiteRealtyAssetEntityRepository iSiteRealtyAssetEntityRepository;

    public Optional<SiteRealtyAssetEntity> fetchBySiteRealtyAssetEntityId(Long id) {
        return iSiteRealtyAssetEntityRepository.findById(id);
    }
}

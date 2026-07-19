package com.karur.asset_management_application.repository;

import com.karur.asset_management_application.entity.asset.realty.SiteEntity;
import com.karur.asset_management_application.repository.inter.ISiteEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class SiteEntityRepository {

    @Autowired
    ISiteEntityRepository iSiteEntityRepository;

    public Optional<SiteEntity> fetchBySiteRealtyAssetEntityId(Long id) {
        return iSiteEntityRepository.findById(id);
    }
}

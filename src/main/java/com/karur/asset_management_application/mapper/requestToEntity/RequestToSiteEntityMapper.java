package com.karur.asset_management_application.mapper.requestToEntity;

import com.karur.asset_management_application.entity.asset.realty.SiteEntity;
import com.karur.asset_management_application.model.read.SiteDetail;
import com.karur.asset_management_application.model.request.SiteRequest;
import org.springframework.stereotype.Component;

@Component
public class RequestToSiteEntityMapper {

    public static SiteEntity buildSiteEntity(SiteRequest siteRequest) {
        SiteEntity siteEntity = SiteEntity.builder().build();
        siteEntity.setNumber(siteRequest.getNumber());
        siteEntity.setRegistrationDate(siteEntity.getRegistrationDate());
        siteEntity.setNELength(siteEntity.getNELength());
        siteEntity.setESLength(siteRequest.getESLength());
        siteEntity.setSWLength(siteRequest.getSWLength());
        siteEntity.setWNLength(siteRequest.getWNLength());
        return siteEntity;
    }
}

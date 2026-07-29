package com.karur.asset_management_application.mapper.entityToRequet;

import com.karur.asset_management_application.entity.asset.realty.SiteEntity;
import com.karur.asset_management_application.model.read.SiteDetail;
import com.karur.asset_management_application.model.request.SiteRequest;
import org.springframework.stereotype.Component;

@Component
public class EntityToSiteRequestMapper {

    public static SiteRequest buildSiteRequest(SiteEntity siteEntity){
        return SiteRequest.builder()
                .number(siteEntity.getNumber())
                .registrationDate(siteEntity.getRegistrationDate())
                .nELength(siteEntity.getNELength())
                .eSLength(siteEntity.getESLength())
                .sWLength(siteEntity.getSWLength())
                .wNLength(siteEntity.getWNLength())
                .build();
    }
}

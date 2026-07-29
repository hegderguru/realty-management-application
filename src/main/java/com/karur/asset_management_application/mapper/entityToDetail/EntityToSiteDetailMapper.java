package com.karur.asset_management_application.mapper.entityToDetail;

import com.karur.asset_management_application.entity.asset.realty.SiteEntity;
import com.karur.asset_management_application.model.read.SiteDetail;
import org.springframework.stereotype.Component;

@Component
public class EntityToSiteDetailMapper {

    public static SiteDetail buildSiteDetail(SiteEntity siteEntity){
        return SiteDetail.builder()
                .number(siteEntity.getNumber())
                .registrationDate(siteEntity.getRegistrationDate())
                .nELength(siteEntity.getNELength())
                .eSLength(siteEntity.getESLength())
                .sWLength(siteEntity.getSWLength())
                .wNLength(siteEntity.getWNLength())
                .build();
    }
}

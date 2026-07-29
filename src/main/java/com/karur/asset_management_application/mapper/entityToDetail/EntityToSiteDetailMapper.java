package com.karur.asset_management_application.mapper.entityToDetail;

import com.karur.asset_management_application.entity.asset.realty.SiteEntity;
import com.karur.asset_management_application.model.price.Price;
import com.karur.asset_management_application.model.price.PricePerUnit;
import com.karur.asset_management_application.model.read.SiteDetail;
import org.springframework.stereotype.Component;

@Component
public class EntityToSiteDetailMapper {

    public static SiteDetail buildSiteDetail(SiteEntity siteEntity) {
        return SiteDetail.builder()
                .number(siteEntity.getNumber())
                .registrationDate(siteEntity.getRegistrationDate())
                .nELength(siteEntity.getNELength())
                .eSLength(siteEntity.getESLength())
                .sWLength(siteEntity.getSWLength())
                .wNLength(siteEntity.getWNLength())
                .price(Price.builder()
                        .priceMeasurementUnit(siteEntity.getPrice().getPriceMeasurementUnit())
                        .pricePerUnit(PricePerUnit.builder()
                                .currency(siteEntity.getPrice().getPricePerUnit().getCurrency())
                                .amount(siteEntity.getPrice().getPricePerUnit().getAmount())
                                .build())
                        .build())
                .build();
    }
}

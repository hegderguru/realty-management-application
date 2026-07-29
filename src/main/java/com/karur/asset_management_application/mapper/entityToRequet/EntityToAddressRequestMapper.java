package com.karur.asset_management_application.mapper.entityToRequet;

import com.karur.asset_management_application.entity.address.AddressEntity;
import com.karur.asset_management_application.model.request.AddressRequest;
import org.springframework.stereotype.Component;

@Component
public class EntityToAddressRequestMapper {

    public static AddressRequest buildAddressRequest(AddressEntity addressEntity){
        return AddressRequest.builder()
                .number(addressEntity.getNumber())
                .name(addressEntity.getName())
                .line1(addressEntity.getLine1())
                .line2(addressEntity.getLine2())
                .city(addressEntity.getCity())
                .state(addressEntity.getState())
                .country(addressEntity.getCountry())
                .zipCode(addressEntity.getZipCode())
                .phone(addressEntity.getPhone())
                .latitude(addressEntity.getLatitude())
                .longitude(addressEntity.getLongitude())
                .build();
    }
}

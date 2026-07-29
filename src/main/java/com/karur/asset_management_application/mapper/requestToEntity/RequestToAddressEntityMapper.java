package com.karur.asset_management_application.mapper.requestToEntity;

import com.karur.asset_management_application.entity.address.AddressEntity;
import com.karur.asset_management_application.model.request.AddressRequest;
import org.springframework.stereotype.Component;

@Component
public class RequestToAddressEntityMapper {

    public static AddressEntity buildAddressEntity(AddressRequest addressRequest) {
        return AddressEntity.builder()
                .number(addressRequest.getNumber())
                .name(addressRequest.getName())
                .line1(addressRequest.getLine1())
                .line2(addressRequest.getLine2())
                .city(addressRequest.getCity())
                .state(addressRequest.getState())
                .country(addressRequest.getCountry())
                .zipCode(addressRequest.getZipCode())
                .phone(addressRequest.getPhone())
                .latitude(addressRequest.getLatitude())
                .longitude(addressRequest.getLongitude())
                .build();
    }
}

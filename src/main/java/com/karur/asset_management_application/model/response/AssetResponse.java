package com.karur.asset_management_application.model.response;

import com.karur.asset_management_application.model.read.OrganisationUserDetail;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class AssetResponse {
    private HttpStatus code;
    private String message;
    private OrganisationUserDetail organisationUserDetail;

    public AssetResponse(HttpStatus code, String message, OrganisationUserDetail organisationUserDetail){
        this.code=code;
        this.message=message;
        this.organisationUserDetail = organisationUserDetail;
    }

    public static class SuccessResponse extends AssetResponse{
        public SuccessResponse(HttpStatus code, String message, OrganisationUserDetail organisationUserDetail){
            super(code,message, organisationUserDetail);
        }
    }

    public static class FailureResponse extends AssetResponse{
        public FailureResponse(HttpStatus code, String message, OrganisationUserDetail organisationUserDetail){
            super(code,message, organisationUserDetail);
        }
    }
}

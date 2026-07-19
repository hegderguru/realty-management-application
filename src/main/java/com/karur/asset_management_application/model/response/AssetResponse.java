package com.karur.asset_management_application.model.response;

import com.karur.asset_management_application.model.read.UserDetail;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class AssetResponse {
    private HttpStatus code;
    private String message;
    private UserDetail userDetail;

    public AssetResponse(HttpStatus code,String message,UserDetail userDetail){
        this.code=code;
        this.message=message;
        this.userDetail=userDetail;
    }

    public static class SuccessResponse extends AssetResponse{
        public SuccessResponse(HttpStatus code,String message,UserDetail userDetail){
            super(code,message,userDetail);
        }
    }

    public static class FailureResponse extends AssetResponse{
        public FailureResponse(HttpStatus code,String message,UserDetail userDetail){
            super(code,message,userDetail);
        }
    }
}

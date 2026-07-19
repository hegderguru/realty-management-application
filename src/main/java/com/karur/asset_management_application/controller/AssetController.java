package com.karur.asset_management_application.controller;

import com.karur.asset_management_application.model.response.AssetResponse;
import com.karur.asset_management_application.service.OrgUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("asset")
public class AssetController {

    @Autowired
    OrgUserService orgUserService;

    @GetMapping("orgUser/{username}")
    public Mono<ResponseEntity<AssetResponse>> fetchOrgUserByName(@PathVariable Mono<String> usernameMono){
       return usernameMono.flatMap(username -> orgUserService.fetchUserDetailByUsername(username))
               .map(userDetail -> ResponseEntity.ok(AssetResponse.SuccessResponse.builder()
                       .userDetail(userDetail).code(HttpStatus.OK).build()))
               .switchIfEmpty(Mono.just(ResponseEntity.badRequest().body(AssetResponse.FailureResponse.builder().build())));
    }

}

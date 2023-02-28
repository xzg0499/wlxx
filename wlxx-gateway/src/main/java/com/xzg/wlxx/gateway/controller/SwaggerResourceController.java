package com.xzg.wlxx.gateway.controller;

import com.xzg.wlxx.gateway.config.SwaggerResourceProviderConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger.web.SwaggerResource;

import java.util.List;

@RestController
@RequestMapping("/swagger-resources")
@RequiredArgsConstructor
public class SwaggerResourceController {


    private final SwaggerResourceProviderConfig swaggerResourceProviderConfig;

    @RequestMapping
    public ResponseEntity<List<SwaggerResource>> swaggerResources() {
        return new ResponseEntity<>(swaggerResourceProviderConfig.get(), HttpStatus.OK);
    }
}


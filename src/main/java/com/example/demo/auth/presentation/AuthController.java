package com.example.demo.auth.presentation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.init}/authorizations/")
@Slf4j
public class AuthController {
    @GetMapping("check")
    public Boolean check(@RequestParam String httpMethod, String requestPath){
        //TODO : httpMethod, requestPath, userRole 테이블에서 권한 판단 후 return
        log.info("httpMethod : {}, requestPath: {}",httpMethod, requestPath);
        return true;
    }
}

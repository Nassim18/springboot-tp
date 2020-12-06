package fr.umontpellier.fds.m2.springboottp.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/appVersion")
public class HomeController {

    @Value("${app.version}")
    private String appVersion;

    @GetMapping
    @RequestMapping("/")
    public String getAppVersion() {
        if(appVersion == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "App version's not found");
        }
            return appVersion;
    }
}

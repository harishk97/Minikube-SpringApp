package com.example.Minikube.deploy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/system")
public class Testcontoller {

    private final Application Application;

    @Autowired
    public Testcontoller(Application systemInfoService) {
        this.Application = systemInfoService;
    }
    @GetMapping("/data")
    String getMessage() {
        return "This message from pod";
    }
    @GetMapping("/time")
    public String getSystemTime() {
        return "Current Time is - " + Application.getCurrentSystemTime();
    }

    @GetMapping("/hostname")
    public String getHostName() {
        return "Running for the hostname - " + Application.getHostName();
    }

}

package com.learn.loadbalancer.service.backend;

import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

public abstract class BackendService {
    protected final String serverUrl;

    public BackendService(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public abstract ResponseEntity executeRequest(HttpServletRequest request);
}

package com.learn.loadbalancer.service;

import com.learn.loadbalancer.model.LBConfig;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public abstract class AbstractLBStrategy {
    protected final LBConfig config;

    public AbstractLBStrategy(LBConfig config) {
        this.config = config;
    }

    public abstract ResponseEntity executeStrategy(HttpServletRequest request);
}

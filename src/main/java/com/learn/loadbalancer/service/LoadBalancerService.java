package com.learn.loadbalancer.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public interface LoadBalancerService {

    public ResponseEntity loadBalance(HttpServletRequest request);
}

package com.learn.loadbalancer.resources;

import com.learn.loadbalancer.service.LoadBalancerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoadBalancerResource {
    @Qualifier("loadBalancerServiceImpl")
    @Autowired
    private LoadBalancerService service;

    @RequestMapping(value = "{*path}", method = RequestMethod.GET)
    public ResponseEntity proxyGet(HttpServletRequest request) {
        return service.loadBalance(request);
    }

    @RequestMapping(value = "{*path}", method = RequestMethod.POST)
    public ResponseEntity proxyPost(HttpServletRequest request) {
        return service.loadBalance(request);
    }

    @RequestMapping(value = "{*path}", method = RequestMethod.PUT)
    public ResponseEntity proxyPut(HttpServletRequest request) {
        return service.loadBalance(request);
    }

    @RequestMapping(value = "{*path}", method = RequestMethod.DELETE)
    public ResponseEntity proxyDelete(HttpServletRequest request) {
        return service.loadBalance(request);
    }
}

package com.learn.loadbalancer.service.backend;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

public class BackendInstance extends BackendService{
    private final RestTemplate template;
    public BackendInstance(String serverUrl) {
        super(serverUrl);
        template = new RestTemplate();
    }

    @Override
    public ResponseEntity executeRequest(HttpServletRequest request) {
        String uri = request.getRequestURI();
        String queryParams = request.getQueryString();
        String method = request.getMethod();
        HttpEntity req = null;
        try {
            req = new HttpEntity(request.getInputStream());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        ResponseEntity resp = null;
        if (RequestMethod.GET.toString().equals(method)) {
            resp = template.getForEntity(serverUrl+"/"+uri, Object.class);
;       }
        return resp;
    }
}

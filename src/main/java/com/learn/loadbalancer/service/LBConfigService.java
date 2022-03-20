package com.learn.loadbalancer.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LBConfigService {
    public void addBackendServer(String backendServer);
    public void removeBackendServer(String backendServer);
    public List<String> getActiveBackendServers(String backendServer);
}

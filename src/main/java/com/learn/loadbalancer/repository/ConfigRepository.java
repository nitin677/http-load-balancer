package com.learn.loadbalancer.repository;

import com.learn.loadbalancer.model.LBConfig;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ConfigRepository {
    public LBConfig getConfig();
    public LBConfig addBackendServer(String backendServer);
    public LBConfig removeBackendServer(String backendServer);
    public List<String> getActiveBackendServers(String backendServer);
}

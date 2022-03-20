package com.learn.loadbalancer.service;

import com.learn.loadbalancer.repository.ConfigRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LBConfigServiceImpl implements LBConfigService{
    @Autowired
    private ConfigRepository configRepository;

    @Override
    public void addBackendServer(String backendServer) {

    }

    @Override
    public void removeBackendServer(String backendServer) {

    }

    @Override
    public List<String> getActiveBackendServers(String backendServer) {
        return null;
    }
}

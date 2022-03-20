package com.learn.loadbalancer.repository;

import com.learn.loadbalancer.model.LBConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

@Component
public class ConfigRepositoryImpl implements ConfigRepository{
    private static final Logger logger = Logger.getLogger(ConfigRepositoryImpl.class.getName());
    @Autowired
    private LBConfig config;

    @PostConstruct
    public void initialize() {
        logger.info("Config initialized: "+config);
    }

    @Override
    public LBConfig getConfig() {
        return this.config;
    }

    @Override
    public LBConfig addBackendServer(String backendServer) {
        return null;
    }

    @Override
    public LBConfig removeBackendServer(String backendServer) {
        return null;
    }

    @Override
    public List<String> getActiveBackendServers(String backendServer) {
        return null;
    }
}

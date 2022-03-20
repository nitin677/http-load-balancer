package com.learn.loadbalancer.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class LBConfig {
    @Value("${backend_servers}" )
    private List<String> backendServers;

    @Value("${service_timeout_in_ms}")
    private int timeOutMillis;

    @Value("${healthcheck_interval_in_seconds}")
    private int healthCheckIntervalSeconds;

    @Value("${healthcheck_url}")
    private String healthCheckUrl;

    @Value("${healthcheck_port}")
    private int port;

    @Value("${failure_threshold_times}")
    private int failureThresholdTimes;

    public int getTimeOutMillis() {
        return timeOutMillis;
    }

    public void setTimeOutMillis(int timeOutMillis) {
        this.timeOutMillis = timeOutMillis;
    }

    public int getHealthCheckIntervalSeconds() {
        return healthCheckIntervalSeconds;
    }

    public void setHealthCheckIntervalSeconds(int healthCheckIntervalSeconds) {
        this.healthCheckIntervalSeconds = healthCheckIntervalSeconds;
    }

    public String getHealthCheckUrl() {
        return healthCheckUrl;
    }

    public void setHealthCheckUrl(String healthCheckUrl) {
        this.healthCheckUrl = healthCheckUrl;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getFailureThresholdTimes() {
        return failureThresholdTimes;
    }

    public void setFailureThresholdTimes(int failureThresholdTimes) {
        this.failureThresholdTimes = failureThresholdTimes;
    }

    public String getDistributionType() {
        return distributionType;
    }

    public void setDistributionType(String distributionType) {
        this.distributionType = distributionType;
    }

    @Value("${distribution_type}")
    private String distributionType;

    public List<String> getBackendServers() {
        return backendServers;
    }

    public void setBackendServers(List<String> backendServers) {
        this.backendServers = backendServers;
    }

    @Override
    public String toString() {
        return backendServers+"";
    }
}

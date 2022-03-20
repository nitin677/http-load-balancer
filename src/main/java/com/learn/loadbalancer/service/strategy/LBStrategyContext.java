package com.learn.loadbalancer.service.strategy;

import com.learn.loadbalancer.model.LBConfig;
import com.learn.loadbalancer.service.AbstractLBStrategy;
import com.learn.loadbalancer.service.RoundRobinStrategy;

public class LBStrategyContext {
    private final LBConfig config;

    public LBStrategyContext(LBConfig config) {
        this.config = config;
    }

    public AbstractLBStrategy getLBStrategy() {
        if (config.getDistributionType().equals("RR")) {
            return new RoundRobinStrategy(config);
        }
        return new RoundRobinStrategy(config);
    }
}

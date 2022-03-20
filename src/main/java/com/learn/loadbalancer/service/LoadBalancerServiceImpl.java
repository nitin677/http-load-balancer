package com.learn.loadbalancer.service;

import com.learn.loadbalancer.repository.ConfigRepository;
import com.learn.loadbalancer.service.strategy.LBStrategyContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

@Service
public class LoadBalancerServiceImpl implements LoadBalancerService{
    private static final Logger logger = Logger.getLogger(LoadBalancerServiceImpl.class.getName());
    private AbstractLBStrategy strategy;

    @Qualifier("configRepositoryImpl")
    @Autowired
    private ConfigRepository configRepo;

    @PostConstruct
    public void initialize() {
        logger.info("Initializing LoadBalancerServiceImpl with config "+configRepo.getConfig());
        strategy = new LBStrategyContext(configRepo.getConfig()).getLBStrategy();
    }

    @Override
    public ResponseEntity loadBalance(HttpServletRequest request) {
        return strategy.executeStrategy(request);
    }
}

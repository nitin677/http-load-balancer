package com.learn.loadbalancer.service;

import com.learn.loadbalancer.model.LBConfig;
import com.learn.loadbalancer.service.backend.BackendInstance;
import com.learn.loadbalancer.service.backend.BackendService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

@Component
public class RoundRobinStrategy extends AbstractLBStrategy {
    private static final Logger               logger    = Logger.getLogger(RoundRobinStrategy.class.getName());
    private              AtomicInteger        serverNum = new AtomicInteger(0);
    private              List<BackendService> servers;
    public RoundRobinStrategy(LBConfig config) {
        super(config);
        initializeBackend();
    }

    private void initializeBackend() {
        servers = config.getBackendServers().stream()
                                             .map(b -> new BackendInstance(b)).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity executeStrategy(HttpServletRequest request) {
        int currentServer = serverNum.getAndIncrement();
        if (currentServer == servers.size() - 1) {
            serverNum.set(0);
        }
        logger.info("Sending request to server "+currentServer);
        BackendService service = servers.get(currentServer);
        return service.executeRequest(request);
    }
}

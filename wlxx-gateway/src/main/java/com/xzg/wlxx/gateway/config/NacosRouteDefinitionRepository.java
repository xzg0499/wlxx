//package com.xzg.wlxx.gateway.config;
//
//import com.alibaba.cloud.nacos.NacosConfigManager;
//import com.alibaba.nacos.api.config.listener.Listener;
//import com.alibaba.nacos.api.exception.NacosException;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
//import org.springframework.cloud.gateway.route.RouteDefinition;
//import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
//import org.springframework.context.ApplicationEventPublisher;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//import java.util.concurrent.Executor;
//
//@Slf4j
//public class NacosRouteDefinitionRepository implements RouteDefinitionRepository {
//
//    private static final String SCG_DATA_ID = "wlxx-routes";
//    private static final String SCG_GROUP_ID = "DEFAULT_GROUP";
//    private ApplicationEventPublisher publisher;
//    //    private NacosConfigProperties properties;
//    private NacosConfigManager nacosConfigManager;
//
//    NacosRouteDefinitionRepository(ApplicationEventPublisher publisher
//            , NacosConfigManager nacosServiceManager) {
//        this.publisher = publisher;
//        this.nacosConfigManager = nacosServiceManager;
//        addListener();
//    }
//
//    @Override
//    public Flux<RouteDefinition> getRouteDefinitions() {
//        return null;
//    }
//
//    private void addListener() {
//        try {
//            nacosConfigManager.getConfigService().addListener(SCG_DATA_ID, SCG_GROUP_ID, new Listener() {
//                @Override
//                public Executor getExecutor() {
//                    return null;
//                }
//
//                @Override
//                public void receiveConfigInfo(String configInfo) {
//                    publisher.publishEvent(new RefreshRoutesEvent(this));
//                }
//            });
//        } catch (NacosException e) {
//            e.printStackTrace();
//            log.info("dynamic route error");
//        }
//    }
//
//    @Override
//    public Mono<Void> save(Mono<RouteDefinition> route) {
//        return null;
//    }
//
//    @Override
//    public Mono<Void> delete(Mono<String> routeId) {
//        return null;
//    }
//}

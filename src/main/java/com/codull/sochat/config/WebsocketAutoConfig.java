package com.codull.sochat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @program: sochat
 * @description:
 * @author: anthony1314
 * @create: 2020-02-26 00:19
 **/
@Configuration
public class WebsocketAutoConfig {
    @Bean
    public ServerEndpointExporter endpointExporter() {
        return new ServerEndpointExporter();
    }
}
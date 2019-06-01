package com.ct.system;

import com.ct.system.controller.MainController;
import com.ct.system.util.Constants;
import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.servlet.MultipartConfigElement;

/**
 * Created by chentong1 on 2019/6/1.
 */

@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableScheduling
public class ElectricityApplication implements EmbeddedServletContainerCustomizer {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ElectricityApplication.class, args);
        MainController mainController = context.getBean(MainController.class);
        mainController.init(Constants.ADMIN_NAME, Constants.ADMIN_PWD);
    }

    @Bean
    public TomcatEmbeddedServletContainerFactory tomcatEmbedded() {
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
        tomcat.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
            if ((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)) {
                //-1 means unlimited
                ((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);
            }
        });
        return tomcat;
    }

    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory config = new MultipartConfigFactory();
        config.setMaxFileSize("100MB");
        config.setMaxRequestSize("100MB");
        return config.createMultipartConfig();
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(8080);
    }
}

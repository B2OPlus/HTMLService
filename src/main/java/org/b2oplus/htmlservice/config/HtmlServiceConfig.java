package org.b2oplus.htmlservice.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * Created by abuabdul
 */
@Configuration
public class HtmlServiceConfig {

    public static final Logger logger = LoggerFactory.getLogger(HtmlServiceConfig.class);

    @Value("${email.host}")
    private String host;
    @Value("${email.port}")
    private int port;
    @Value("${email.admin.username}")
    private String username;
    @Value("${email.admin.password}")
    private String password;
    @Value("${email.authentication}")
    private String authentication;
    @Value("${email.tls.enable}")
    private String tlsEnabled;

    @Bean
    public JavaMailSender adminMailSender() {
        JavaMailSenderImpl adminMailSender = new JavaMailSenderImpl();
        adminMailSender.setHost(host);
        adminMailSender.setPort(port);
        adminMailSender.setUsername(username);
        adminMailSender.setPassword(password);
        adminMailSender.setJavaMailProperties(javaMailProperties());
        return adminMailSender;
    }

    private Properties javaMailProperties() {
        Properties prop = new Properties();
        prop.setProperty("mail.smtp.auth", authentication);
        prop.setProperty("mail.smtp.starttls.enable", tlsEnabled);
        return prop;
    }
}

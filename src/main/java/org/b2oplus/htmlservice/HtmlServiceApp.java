package org.b2oplus.htmlservice;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by abuabdul
 */
@SpringBootApplication
@EnableEncryptableProperties
@PropertySource(name = "EncryptedProperties", value = "classpath:encrypted.properties")
public class HtmlServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(HtmlServiceApp.class, args);
    }
}

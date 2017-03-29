package org.b2oplus.htmlservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by abuabdul
 */
@ConfigurationProperties(prefix = "origins")
public class HtmlServiceOriginProperty {

    private String b2oplus;

    public String getB2oplus() {
        return b2oplus;
    }

    public void setB2oplus(String b2oplus) {
        this.b2oplus = b2oplus;
    }
}

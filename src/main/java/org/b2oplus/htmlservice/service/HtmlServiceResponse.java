package org.b2oplus.htmlservice.service;

import java.io.Serializable;

/**
 * Created by abuabdul
 */
public class HtmlServiceResponse implements Serializable {

    protected String status;

    public HtmlServiceResponse(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "HtmlServiceResponse{" +
                "status='" + status + '\'' +
                '}';
    }
}

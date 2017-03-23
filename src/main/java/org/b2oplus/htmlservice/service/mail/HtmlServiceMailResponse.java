package org.b2oplus.htmlservice.service.mail;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.b2oplus.htmlservice.service.HtmlServiceResponse;

/**
 * Created by abuabdul
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HtmlServiceMailResponse extends HtmlServiceResponse {

    public HtmlServiceMailResponse(String status) {
        super(status);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "HtmlServiceMailResponse{" +
                "status='" + super.status + '\'' +
                '}';
    }
}

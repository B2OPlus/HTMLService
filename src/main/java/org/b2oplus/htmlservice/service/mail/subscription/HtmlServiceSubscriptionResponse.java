package org.b2oplus.htmlservice.service.mail.subscription;

import org.b2oplus.htmlservice.service.HtmlServiceResponse;

/**
 * Created by abuabdul
 */
public class HtmlServiceSubscriptionResponse extends HtmlServiceResponse {

    public HtmlServiceSubscriptionResponse(String status) {
        super(status);
    }

    @Override
    public String toString() {
        return "HtmlServiceSubscriptionResponse{" +
                "status='" + super.status + '\'' +
                '}';
    }

}

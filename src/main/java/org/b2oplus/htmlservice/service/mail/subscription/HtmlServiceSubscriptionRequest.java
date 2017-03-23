package org.b2oplus.htmlservice.service.mail.subscription;

import org.b2oplus.htmlservice.service.mail.HtmlServiceMailRequest;

/**
 * Created by abuabdul
 */
public class HtmlServiceSubscriptionRequest extends HtmlServiceMailRequest {

    private String subscriberMail;

    public String getSubscriberMail() {
        return subscriberMail;
    }

    public void setSubscriberMail(String subscriberMail) {
        this.subscriberMail = subscriberMail;
    }

    @Override
    public String toString() {
        return "HtmlServiceSubscriptionRequest{" +
                "subscriberMail='" + subscriberMail + '\'' +
                '}';
    }
}

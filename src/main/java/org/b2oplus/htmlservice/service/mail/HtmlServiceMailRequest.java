package org.b2oplus.htmlservice.service.mail;

import org.b2oplus.htmlservice.service.HtmlServiceRequest;

/**
 * Created by abuabdul
 */
public class HtmlServiceMailRequest extends HtmlServiceRequest {

    private String fromAddress;
    private String toAddress;
    private String subject;
    private String messageBody;

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    @Override
    public String toString() {
        return "HtmlServiceMailRequest[" +
                "fromAddress='" + fromAddress + '\'' +
                ", toAddress='" + toAddress + '\'' +
                ", subject='" + subject + '\'' +
                ", messageBody='" + messageBody + '\'' +
                "]";
    }
}

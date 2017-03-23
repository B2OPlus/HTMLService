package org.b2oplus.htmlservice.errors;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by abuabdul
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HtmlServiceError {

    private int status;
    private String message;

    public HtmlServiceError(final int status) {
        this.status = status;
    }

    public HtmlServiceError(final String message) {
        this.message = message;
    }

    public HtmlServiceError(final int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HtmlServiceError{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}

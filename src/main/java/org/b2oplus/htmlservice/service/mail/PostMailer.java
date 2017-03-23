package org.b2oplus.htmlservice.service.mail;

/**
 * Created by abuabdul
 */
@FunctionalInterface
public interface PostMailer {

    HtmlServiceMailResponse sendAMail(final HtmlServiceMailRequest req);

}

package org.b2oplus.htmlservice.service.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;

/**
 * Created by abuabdul
 */
@Service
public class PostMailerService implements PostMailer {

    private static final Logger log = LoggerFactory.getLogger(PostMailerService.class);

    private static final String ENCODING = "utf-8";
    private static final String TYPE = "html";

    @Autowired
    private JavaMailSender adminMailSender;

    @Override
    public HtmlServiceMailResponse sendAMail(final HtmlServiceMailRequest req) {
        log.debug("PostMailerService.sendAMail invoked");
        adminMailSender.send(mimeMessage -> {
            mimeMessage.setFrom(new InternetAddress(req.getFromAddress()));
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(req.getToAddress()));
            mimeMessage.setSubject(req.getSubject());
            mimeMessage.setText(req.getMessageBody(), ENCODING, TYPE);
        });
        return new HtmlServiceMailResponse(HttpStatus.OK.name());
    }
}

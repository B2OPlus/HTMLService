package org.b2oplus.htmlservice.controller;

import org.b2oplus.htmlservice.service.mail.HtmlServiceMailRequest;
import org.b2oplus.htmlservice.service.mail.PostMailer;
import org.b2oplus.htmlservice.service.mail.subscription.HtmlServiceSubscriptionRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
public class HtmlServiceRestController {

    public static final Logger logger = LoggerFactory.getLogger(HtmlServiceRestController.class);

    @Autowired
    private PostMailer mailer;

    @Value("${email.admin.username}")
    private String fromAdminEmail;

    @Value("${email.admin.recipient}")
    private String recipientMail;

    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> sayhello(HttpServletResponse response) {
        logger.info("HTML Service API says Hello");
        response.addHeader("Content-type", "application/json");
        return new ResponseEntity("Hello", HttpStatus.OK);
    }

    @RequestMapping(value = "/careers", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> careers() {
        logger.info("HTML Service Careers Page");
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/contact/us", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> contactUs(HtmlServiceMailRequest req) {
        logger.info("HTML Service contactUs Form Submit Request");
        try {
            // From address will be overridden since we use our mail address to send
            req.setFromAddress(fromAdminEmail);
            req.setToAddress(recipientMail);
            return new ResponseEntity(mailer.sendAMail(req), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/subscribe", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> subscribeWithUs(HtmlServiceSubscriptionRequest req) {
        logger.info("HTML Service subscribe us Request");
        try {
            // From address will be overridden since we use our mail address to send
            req.setFromAddress(fromAdminEmail);
            req.setToAddress(recipientMail);
            return new ResponseEntity(mailer.sendAMail(req), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
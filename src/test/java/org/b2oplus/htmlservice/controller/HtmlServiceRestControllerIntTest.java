package org.b2oplus.htmlservice.controller;

import org.b2oplus.htmlservice.service.mail.HtmlServiceMailRequest;
import org.b2oplus.htmlservice.service.mail.HtmlServiceMailResponse;
import org.b2oplus.htmlservice.service.mail.PostMailer;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Created by abuabdul
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class HtmlServiceRestControllerIntTest {

    public static final Logger logger = LoggerFactory.getLogger(HtmlServiceRestControllerIntTest.class);

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private PostMailer postMailer;

    @Value("${email.admin.username}")
    private String fromAdminEmail;

    @Value("${email.admin.recipient}")
    private String recipientMail;

    @BeforeClass
    public static void init() {
        System.setProperty("jasypt.encryptor.password", System.getenv("APP_ENCRYPTION_PASSWORD"));
    }

    @Test
    public void testSayhello() throws Exception {
        logger.info("Testing sayHello API-----------");
        ResponseEntity<String> response = restTemplate.getForEntity("/api/hello", String.class);
        Assert.assertEquals("Hello", response.getBody());
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals("application", response.getHeaders().getContentType().getType());
        Assert.assertEquals("json", response.getHeaders().getContentType().getSubtype());
        Assert.assertEquals(UTF_8, response.getHeaders().getContentType().getCharset());
    }

    @Test
    public void testCareers() throws Exception {
        logger.info("Testing Careers Page API-----------");
        ResponseEntity response = restTemplate.getForEntity("/api/careers", void.class);
        Assert.assertEquals(null, response.getBody());
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testContactUs() throws Exception {
        logger.info("Testing Contact Us Form Submit Request API-----------");
        HtmlServiceMailRequest req = new HtmlServiceMailRequest();
        req.setFromAddress(fromAdminEmail);
        req.setToAddress(recipientMail);
        req.setSubject("Test Subject");
        req.setMessageBody("Message");
        ResponseEntity<HtmlServiceMailResponse> response = restTemplate.postForEntity("/api/contact/us", req, HtmlServiceMailResponse.class);
        Assert.assertEquals(null, response.getBody());
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testSubscribeWithUs() throws Exception {
        logger.info("Testing subscribe us Request API-----------");
        HtmlServiceMailRequest req = new HtmlServiceMailRequest();
        req.setFromAddress(fromAdminEmail);
        req.setToAddress(recipientMail);
        req.setSubject("Test Subject");
        req.setMessageBody("Subscribe");
        ResponseEntity<HtmlServiceMailResponse> response = restTemplate.postForEntity("/api/subscribe", req, HtmlServiceMailResponse.class);
        Assert.assertEquals(null, response.getBody());
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}

package org.b2oplus.htmlservice.service.mail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.notNull;

/**
 * Created by abuabdul
 */
@RunWith(SpringRunner.class)
public class PostMailerServiceTest {

    @Value("${email.admin.username}")
    private String fromAdminEmail;

    @Value("${email.admin.recipient}")
    private String recipientMail;

    @MockBean
    private PostMailerService mailerService;

    @Before
    public void setup() {
        given(this.mailerService.sendAMail(any())).willReturn(new HtmlServiceMailResponse(HttpStatus.OK.name()));
    }

    @Test
    public void sendAMail() throws Exception {
        HtmlServiceMailRequest req = new HtmlServiceMailRequest();
        req.setFromAddress(fromAdminEmail);
        req.setToAddress(recipientMail);
        req.setSubject("Test Subject");
        req.setMessageBody("Message");
        HtmlServiceMailResponse response = mailerService.sendAMail(req);
        assertThat(response.getStatus(), is(HttpStatus.OK.name()));
        assertNotNull(response);
    }

}
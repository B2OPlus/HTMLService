package org.b2oplus.htmlservice.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.b2oplus.htmlservice.errors.HtmlServiceError;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by abuabdul
 */
@RestController
public class HtmlServiceErrorController implements ErrorController {

    private static final String PATH = "/error";

    @Override
    public String getErrorPath() {
        return PATH;
    }

    @RequestMapping(value = PATH, method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> errorPath(HttpServletRequest request, Exception ex) {
        HttpStatus status = getStatus(request);
        if (ex == null || ex.getMessage() == null) {
            return new ResponseEntity<>(new HtmlServiceError(status.value()), status);
        }
        return new ResponseEntity<>(new HtmlServiceError(status.value(), ex.getMessage()), status);
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }

}
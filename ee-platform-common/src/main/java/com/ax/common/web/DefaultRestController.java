package com.ax.common.web;

import com.ax.common.exception.ApplicationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.NOT_FOUND;


/**
 * Created by kyy on 2017/9/7.
 */
@RestController
public class DefaultRestController {

    @RequestMapping
    public ResponseEntity<RestErrorResponse> handleUnmappedRequest() {
        return ResponseEntity.status(NOT_FOUND).body(RestErrorResponse.create(NOT_FOUND));
    }


    @GetMapping("/exception")
    public void handleExceptionRequest() {
        throw new ApplicationException("new Exception");
    }


}

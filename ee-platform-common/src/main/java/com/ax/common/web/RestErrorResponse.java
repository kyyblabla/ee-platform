package com.ax.common.web;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Objects;

/**
 * Created by kyy on 2017/9/7.
 */
@Data
public class RestErrorResponse {

    private final int statusCode;
    private final String reasonPhrase;
    private final String detailMessage;

    protected RestErrorResponse(HttpStatus status, String detailMessage) {
        statusCode = status.value();
        reasonPhrase = status.getReasonPhrase();
        this.detailMessage = detailMessage;
    }

    public static RestErrorResponse create(HttpStatus status) {
        return create(status, null);
    }

    public static RestErrorResponse create(HttpStatus status, Exception ex) {
        return new RestErrorResponse(status, Objects.isNull(ex) ? "" : ex.getMessage());
    }


}

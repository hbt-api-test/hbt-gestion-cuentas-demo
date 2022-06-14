package com.heinsohn.obl.exception;



import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;


@Provider
@Slf4j
public class ApiExceptionHandler implements ExceptionMapper<ApiRequestException> {


    @Override
    public Response toResponse(ApiRequestException e) {
        return Response.status(NOT_FOUND)
                .entity(ApiException.builder().httpStatus(NOT_FOUND.getStatusCode())
                        .title(e.getMessage())
                        .type("Error")
                        .zonedDateTime(ZonedDateTime.now(ZoneId.of("Z"))).build())
                .build();
    }
}

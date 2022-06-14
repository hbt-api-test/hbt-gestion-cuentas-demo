package com.heinsohn.obl.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiException {

    private String type;
    private String title;
    private int httpStatus;
    private ZonedDateTime zonedDateTime;

}

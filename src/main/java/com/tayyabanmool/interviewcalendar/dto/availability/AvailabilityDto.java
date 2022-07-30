package com.tayyabanmool.interviewcalendar.dto.availability;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class AvailabilityDto {

    private Long id;

    @Min(value=1, message="From: positive number, min 1 is required")
    @Max(value=23, message="From: positive number, max 23 is required")
    private int hourFrom;

    @Min(value=2, message="To: positive number, min 2 is required")
    @Max(value=24, message="To: positive number, max 24 is required")
    private int hourTo;

    @NotNull
    private Date date;

    @NotNull
    private Long userId;
}

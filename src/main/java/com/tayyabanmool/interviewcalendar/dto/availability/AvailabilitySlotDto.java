package com.tayyabanmool.interviewcalendar.dto.availability;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * A DTO for the {@link com.tayyabanmool.interviewcalendar.entity.Availability} entity.
 */
@Data
@AllArgsConstructor
public class AvailabilitySlotDto {

    private int hourFrom;

    private int hourTo;

    private Date date;
}

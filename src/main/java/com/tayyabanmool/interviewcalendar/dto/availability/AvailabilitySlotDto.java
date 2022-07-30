package com.tayyabanmool.interviewcalendar.dto.availability;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class AvailabilitySlotDto {

    private int hourFrom;

    private int hourTo;

    private Date date;
}

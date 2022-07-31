package com.tayyabanmool.interviewcalendar.dto.availability;

import lombok.Data;

import java.util.List;

/**
 * A DTO for the check availability search response.
 */
@Data
public class CheckAvailabilityResponseDto {

    private String interviewerName;

    private List<AvailabilitySlotDto> availabilitySlotDtos;
}

package com.tayyabanmool.interviewcalendar.dto.availability;

import lombok.Data;

import java.util.List;

@Data
public class CheckAvailabilityResponseDto {

    private String interviewerName;

    private List<AvailabilitySlotDto> availabilitySlotDtos;
}

package com.tayyabanmool.interviewcalendar.service.availability;

import com.tayyabanmool.interviewcalendar.dto.availability.AvailabilityDto;
import com.tayyabanmool.interviewcalendar.dto.availability.CheckAvailabilityRequestDto;
import com.tayyabanmool.interviewcalendar.dto.availability.CheckAvailabilityResponseDto;

import java.util.List;

public interface AvailabilityService {

    /**
     * create or updated a availability slot.
     *
     * @param availabilityDto to create new slot.
     * @return AvailabilityDto.
     */
    AvailabilityDto createOrUpdateAvailabilitySlot(AvailabilityDto availabilityDto);

    /**
     * check a availability slots.
     *
     * @param checkAvailabilityRequestDto to create new slot.
     * @return all available slots by interviewers.
     */
    List<CheckAvailabilityResponseDto> checkAvailabilitySlot(CheckAvailabilityRequestDto checkAvailabilityRequestDto);
}

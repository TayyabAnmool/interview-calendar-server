package com.tayyabanmool.interviewcalendar.controller;

import com.tayyabanmool.interviewcalendar.dto.availability.AvailabilityDto;
import com.tayyabanmool.interviewcalendar.dto.availability.CheckAvailabilityRequestDto;
import com.tayyabanmool.interviewcalendar.service.availability.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * REST controller for managing {@link com.tayyabanmool.interviewcalendar.entity.Availability}.
 */
@RestController
@RequestMapping("/api/availability")
public class AvailabilityController {

    @Autowired
    private AvailabilityService availabilityService;

    /**
     * {@code Put  /api/availability} : Add a new Availability slot.
     *
     * @param availabilityDto the availabilityDto to add.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new availabilityDto, or with status {@code 400 (Bad Request)} if the provided information is in invalid format or incomplete, or with status {@code 500 (Not Found)} if unable to add for unknown reason.
     */
    @PutMapping("")
    public ResponseEntity<?> createOrUpdateAvailabilitySlot(@Valid @RequestBody AvailabilityDto availabilityDto) {

        if(availabilityDto.getHourFrom()>availabilityDto.getHourTo()){
            return new ResponseEntity<>("Starting time should be less then ending time", HttpStatus.NOT_ACCEPTABLE);
        }

        AvailabilityDto result = availabilityService.createOrUpdateAvailabilitySlot(availabilityDto);
        if (result == null) {
            return new ResponseEntity<>("Some Thing Went Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(result,HttpStatus.CREATED);
    }

    /**
     * {@code Get  /api/availability} : Add a new Availability slot.
     *
     * @param checkAvailabilityRequestDto the availabilityDto to add.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new availabilityDto, or with status {@code 400 (Bad Request)} if the provided information is in invalid format or incomplete, or with status {@code 500 (Not Found)} if unable to add for unknown reason.
     */
    @GetMapping("")
    public ResponseEntity<?> checkAvailabilitySlot(@Valid @RequestBody CheckAvailabilityRequestDto checkAvailabilityRequestDto) {

//        AvailabilityDto result = availabilityService.createOrUpdateAvailabilitySlot(availabilityDto);
//        if (result == null) {
//            return new ResponseEntity<>("Some Thing Went Wrong", HttpStatus.INTERNAL_SERVER_ERROR);
//        }

        return new ResponseEntity<>(availabilityService.checkAvailabilitySlot(checkAvailabilityRequestDto),HttpStatus.CREATED);
    }
}
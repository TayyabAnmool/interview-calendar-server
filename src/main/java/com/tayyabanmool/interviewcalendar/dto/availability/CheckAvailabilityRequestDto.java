package com.tayyabanmool.interviewcalendar.dto.availability;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class CheckAvailabilityRequestDto {

    @Min(value=1,message= "candidate id: positive number value is required")
    private long candidateId;

    @NotNull
    private List<Long> interviewerIds;
}

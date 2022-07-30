package com.tayyabanmool.interviewcalendar.dto;

import com.tayyabanmool.interviewcalendar.enums.UserRole;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * A DTO for the {@link com.tayyabanmool.interviewcalendar.entity.User} entity.
 */
@Data
public class UserDto {

    private Long id;

    @NotBlank
    private String name;

    @NotNull
    private UserRole userRole;
}

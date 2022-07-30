package com.tayyabanmool.interviewcalendar.service.user;

import com.tayyabanmool.interviewcalendar.dto.UserDto;

/**
 * Service Interface for managing {@link com.tayyabanmool.interviewcalendar.entity.User} entity.
 */
public interface UserService {

    /**
     * create a user.
     *
     * @param userDto the entity to register.
     * @return the persisted entity.
     */
    UserDto createUser(UserDto userDto);
}

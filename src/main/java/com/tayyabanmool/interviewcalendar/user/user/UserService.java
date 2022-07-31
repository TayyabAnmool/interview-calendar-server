package com.tayyabanmool.interviewcalendar.user.user;

import com.tayyabanmool.interviewcalendar.dto.user.UserDto;

import java.util.List;

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

    /**
     * get all candidates.
     *
     * @return list of user dto.
     */
    List<UserDto> getAllCandidates();

    /**
     * get all interviewers.
     *
     * @return list of user dto.
     */
     List<UserDto> getAllInterviewers();

    /**
     * get all users.
     *
     * @return list of user dto.
     */
    List<UserDto> getAllUsers();
}

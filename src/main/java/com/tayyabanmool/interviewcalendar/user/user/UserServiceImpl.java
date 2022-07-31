package com.tayyabanmool.interviewcalendar.service.user;

import com.tayyabanmool.interviewcalendar.dto.user.UserDto;
import com.tayyabanmool.interviewcalendar.entity.User;
import com.tayyabanmool.interviewcalendar.enums.UserRole;
import com.tayyabanmool.interviewcalendar.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link com.tayyabanmool.interviewcalendar.entity.User} entity.
 */
@Service
public class UserServiceImpl implements UserService{

    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    /**
     * create a user.
     *
     * @param userDto the entity to create.
     * @return the persisted entity.
     */
    public UserDto createUser(UserDto userDto) {
        log.debug("Request to create Candidate : {}", userDto);
        User user = new User();
        user.setName(userDto.getName());
        user.setUserRole(userDto.getUserRole());

        return userRepository.save(user).getDto();
    }

    /**
     * get all candidates.
     *
     * @return list of user dto.
     */
    public List<UserDto> getAllCandidates() {
        log.debug("Request to get Candidates");
        return userRepository.findAllByUserRole(UserRole.CANDIDATE).stream().map(User::getDto).collect(Collectors.toList());
    }

    /**
     * get all interviewers.
     *
     * @return list of user dto.
     */
    public List<UserDto> getAllInterviewers() {
        log.debug("Request to get Candidates");
        return userRepository.findAllByUserRole(UserRole.INTERVIEWER).stream().map(User::getDto).collect(Collectors.toList());
    }

    /**
     * get all user.
     *
     * @return list of user dto.
     */
    public List<UserDto> getAllUsers() {
        log.debug("Request to get all users");
        return userRepository.findAll().stream().map(User::getDto).collect(Collectors.toList());
    }
}

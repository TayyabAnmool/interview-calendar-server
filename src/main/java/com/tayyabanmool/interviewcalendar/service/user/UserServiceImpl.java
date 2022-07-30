package com.tayyabanmool.interviewcalendar.service.user;

import com.tayyabanmool.interviewcalendar.dto.UserDto;
import com.tayyabanmool.interviewcalendar.entity.User;
import com.tayyabanmool.interviewcalendar.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Override
    public UserDto createUser(UserDto userDto) {
        log.debug("Request to create Candidate : {}", userDto);
        User user = new User();
        user.setName(userDto.getName());
        user.setUserRole(userDto.getUserRole());

        return userRepository.save(user).getDto();
    }
}

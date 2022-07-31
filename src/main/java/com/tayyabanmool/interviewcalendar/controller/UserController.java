package com.tayyabanmool.interviewcalendar.controller;

import com.tayyabanmool.interviewcalendar.dto.user.UserDto;
import com.tayyabanmool.interviewcalendar.user.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * REST controller for managing {@link com.tayyabanmool.interviewcalendar.entity.User}.
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * {@code POST  /api/user} : Register a new User.
     *
     * @param userDto the userDto to Register.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new candidateDTO, or with status {@code 400 (Bad Request)} if the candidate provided information is in invalid format or incomplete, or with status {@code 404 (Not Found)} if unable to register for unknown reason.
     */
    @PostMapping("")
    public ResponseEntity<?> createUser(@Valid @RequestBody(required = true) UserDto userDto) {
        log.debug("REST request to register Candidate : {}", userDto);

        UserDto result = userService.createUser(userDto);
        if (result == null) {
            return new ResponseEntity<>("Some Thing Went Wrong",HttpStatus.INTERNAL_SERVER_ERROR);
        }
       return new ResponseEntity<>(result,HttpStatus.CREATED);
    }

    /**
     * {@code GET  /api/user} : Get All Users.
     *
     * @return the {@link List<UserDto>} with status {@code 200 (OK)} and with List<UserDto>.
     */
    @GetMapping("")
    public List<UserDto> getAllUsers() {
        log.debug("REST request to get All users");
        return userService.getAllUsers();
    }

    /**
     * {@code GET  /api/user/candidates} : Get All Candidates.
     *
     * @return the {@link List<UserDto>} with status {@code 200 (OK)} and List<UserDto>.
     */
    @GetMapping("candidates")
    public List<UserDto> getAllCandidates() {
        log.debug("REST request to register Candidates");
        return userService.getAllCandidates();
    }

    /**
     * {@code GET  /api/user/interviewers} : Get All Candidates.
     *
     * @return the {@link List<UserDto>} with status {@code 200 (OK)} and List<UserDto>.
     */
    @GetMapping("interviewers")
    public List<UserDto> getAllInterviewers() {
        log.debug("REST request to register Candidate");

        return userService.getAllInterviewers();
    }
}

package com.tayyabanmool.interviewcalendar.controller;

import com.tayyabanmool.interviewcalendar.dto.user.UserDto;
import com.tayyabanmool.interviewcalendar.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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

//        Candidate usernameCheckResult = candidateService.getCandidateByUsername(candidateRegisterInput.getUsername());
//        if(usernameCheckResult!=null){
//            return new ResponseEntity<>(SharedDeveloperCodes.USERNAME_ALREADY_EXISTS , HttpStatus.NOT_ACCEPTABLE);
//        }
//        Candidate emailCheckResult = candidateService.getCandidateByEmail(candidateRegisterInput.getEmail()) ;
//        if(emailCheckResult != null){
//            return new ResponseEntity<>(SharedDeveloperCodes.EMAIL_ALREADY_EXISTS ,HttpStatus.NOT_ACCEPTABLE);
//        }
        UserDto result = userService.createUser(userDto);
        if (result == null) {
            return new ResponseEntity<>("Some Thing Went Wrong",HttpStatus.INTERNAL_SERVER_ERROR);
        }
       return new ResponseEntity<>(result,HttpStatus.CREATED);
    }
}

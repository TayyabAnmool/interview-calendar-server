package com.tayyabanmool.interviewcalendar.service;

import com.tayyabanmool.interviewcalendar.dto.user.UserDto;
import com.tayyabanmool.interviewcalendar.entity.User;
import com.tayyabanmool.interviewcalendar.enums.UserRole;
import com.tayyabanmool.interviewcalendar.repository.UserRepository;
import com.tayyabanmool.interviewcalendar.service.user.UserService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

//    @Before
//    public void setUp(){
//        User user = new User();
//        user.setId(999L);
//        user.setUserRole(UserRole.INTERVIEWER);
//        user.setName("Tayyab");
//
//        when(userRepository.save(user)).thenReturn(user);
//
//
//    }


    @Test

    void createUser() {
        User user = new User();
        user.setId(999L);
        user.setUserRole(UserRole.INTERVIEWER);
        user.setName("Tayyab");

        when(userRepository.save(user)).thenReturn(user);
        assertEquals(user.getDto(), userRepository.save(user).getDto());
    }
}
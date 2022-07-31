package com.tayyabanmool.interviewcalendar.service.user;

import com.tayyabanmool.interviewcalendar.dto.user.UserDto;
import com.tayyabanmool.interviewcalendar.entity.User;
import com.tayyabanmool.interviewcalendar.enums.UserRole;
import com.tayyabanmool.interviewcalendar.repository.UserRepository;
import org.junit.Before;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class UserServiceImplTest {

//    @Autowired
//    private UserServiceImpl userServiceImpl;
//
//    @Mock
//    private UserRepository userRepository;
//
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

//    @Test
//    @Disabled
//    void createUser() {
//        User user = new User();
//        user.setId(999L);
//        user.setUserRole(UserRole.INTERVIEWER);
//        user.setName("Tayyab");
//        UserDto userDto = user.getDto();
//
//        assertEquals(user.getDto(), userServiceImpl.createUser(userDto));
//    }
}
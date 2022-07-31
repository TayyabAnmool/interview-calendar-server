package com.tayyabanmool.interviewcalendar.user;

import com.tayyabanmool.interviewcalendar.entity.User;
import com.tayyabanmool.interviewcalendar.enums.UserRole;
import com.tayyabanmool.interviewcalendar.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserTest {

    @Mock
    private UserRepository userRepository;

    @Test

    void createUserTest() {
        User user = new User();
        user.setId(999L);
        user.setUserRole(UserRole.INTERVIEWER);
        user.setName("Tayyab");

        when(userRepository.save(user)).thenReturn(user);
        assertEquals(user.getDto(), userRepository.save(user).getDto());
    }

    @Test
    void findAllByUserRoleTest(){

        List<User> userList = Arrays.asList(
                new User(1L, "karim", UserRole.CANDIDATE),
                new User(2L, "khan", UserRole.CANDIDATE),
                new User(3L, "Adeel", UserRole.CANDIDATE)
        );

        when(userRepository.findAllByUserRole(UserRole.CANDIDATE)).thenReturn(userList);
        assertEquals(3,userRepository.findAllByUserRole(UserRole.CANDIDATE).size());
    }

}
package com.tayyabanmool.interviewcalendar.entity;

import com.tayyabanmool.interviewcalendar.dto.UserDto;
import com.tayyabanmool.interviewcalendar.enums.UserRole;
import lombok.Data;

import javax.persistence.*;

/**
 * A User.
 */
@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private UserRole userRole;

    public UserDto getDto(){
        UserDto userDto = new UserDto();
        userDto.setId(id);
        userDto.setName(name);
        userDto.setUserRole(userRole);

        return userDto;
    }
}

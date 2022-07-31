package com.tayyabanmool.interviewcalendar.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tayyabanmool.interviewcalendar.dto.user.UserDto;
import com.tayyabanmool.interviewcalendar.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * A User.
 */
@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private UserRole userRole;

    @OneToMany(mappedBy = "user", cascade=CascadeType.ALL)
    @JsonIgnore
    private List<Availability> availabilityList;

    public UserDto getDto(){
        UserDto userDto = new UserDto();
        userDto.setId(id);
        userDto.setName(name);
        userDto.setUserRole(userRole);

        return userDto;
    }
}

package com.tayyabanmool.interviewcalendar.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tayyabanmool.interviewcalendar.dto.availability.AvailabilityDto;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

/**
 * A Availability.
 */
@Entity
@Table(name = "availability")
@Data
public class Availability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "availability_id")
    private Long id;

    private int hourFrom;

    private int hourTo;

    private Date date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    public AvailabilityDto getDto(){
        AvailabilityDto availabilityDto = new AvailabilityDto();
        availabilityDto.setId(id);
        availabilityDto.setDate(date);
        availabilityDto.setHourFrom(hourFrom);
        availabilityDto.setHourTo(hourTo);
        availabilityDto.setUserId(user.getId());

        return availabilityDto;
    }

    public void getEntity(AvailabilityDto availabilityDto){
        date = availabilityDto.getDate();
        hourFrom = availabilityDto.getHourFrom();
        hourTo = availabilityDto.getHourTo();
    }
}

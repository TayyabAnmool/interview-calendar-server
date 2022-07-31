package com.tayyabanmool.interviewcalendar.availability;

import com.tayyabanmool.interviewcalendar.entity.Availability;
import com.tayyabanmool.interviewcalendar.entity.User;
import com.tayyabanmool.interviewcalendar.enums.UserRole;
import com.tayyabanmool.interviewcalendar.repository.AvailabilityRepository;
import com.tayyabanmool.interviewcalendar.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AvailabilityTest {

    @Mock
    private AvailabilityRepository availabilityRepository;

    @Test
    void createAvailabilityTest() {
        User user = new User();
        user.setId(999L);
        user.setUserRole(UserRole.INTERVIEWER);
        user.setName("Tayyab");

        Availability availability = new Availability();
        availability.setId(999L);
        availability.setDate(new Date());
        availability.setHourFrom(7);
        availability.setHourTo(9);
        availability.setUser(user);

        when(availabilityRepository.save(availability)).thenReturn(availability);
        assertEquals(availability, availabilityRepository.save(availability));
    }
}

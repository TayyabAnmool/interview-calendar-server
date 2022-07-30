package com.tayyabanmool.interviewcalendar.repository;

import com.tayyabanmool.interviewcalendar.entity.Availability;
import com.tayyabanmool.interviewcalendar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, Long> {

    Optional<Availability> findByDateAndUser(Date date , User user);
}

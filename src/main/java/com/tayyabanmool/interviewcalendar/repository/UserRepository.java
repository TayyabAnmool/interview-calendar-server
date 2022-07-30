package com.tayyabanmool.interviewcalendar.repository;

import com.tayyabanmool.interviewcalendar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data repository for the User entity.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

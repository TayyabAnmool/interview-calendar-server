package com.tayyabanmool.interviewcalendar.repository;

import com.tayyabanmool.interviewcalendar.entity.User;
import com.tayyabanmool.interviewcalendar.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data repository for the User entity.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByIdAndAndUserRole(Long id, UserRole userRole);

    List<User> findAllByIdInAndUserRole(List<Long> ids, UserRole userRole);

    List<User> findAllByUserRole(UserRole userRole);
}

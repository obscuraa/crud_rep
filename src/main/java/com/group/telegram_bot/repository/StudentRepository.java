package com.group.telegram_bot.repository;

import com.group.telegram_bot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {
    Optional<Student> findByTelephone(String telephone);
    Optional<Student> findByEmail(String email);
}

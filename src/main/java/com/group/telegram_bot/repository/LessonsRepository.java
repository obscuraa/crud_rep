package com.group.telegram_bot.repository;

import com.group.telegram_bot.model.Lesson;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LessonsRepository extends JpaRepository<Lesson, UUID> {
    Optional<Lesson> findTop1ByIdAndCreatedGreaterThan(UUID professorId, LocalDateTime now);
}

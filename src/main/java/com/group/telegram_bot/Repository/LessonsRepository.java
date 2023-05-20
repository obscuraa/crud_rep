package com.group.telegram_bot.Repository;

import com.group.telegram_bot.model.Lessons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LessonsRepository extends JpaRepository<Lessons, UUID> {
}

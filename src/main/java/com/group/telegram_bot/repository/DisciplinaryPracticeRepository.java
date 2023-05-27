package com.group.telegram_bot.repository;

import com.group.telegram_bot.model.DisciplinaryPractice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DisciplinaryPracticeRepository extends JpaRepository<DisciplinaryPractice, UUID> {
}

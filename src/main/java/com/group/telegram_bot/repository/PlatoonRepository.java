package com.group.telegram_bot.repository;

import com.group.telegram_bot.model.Platoon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlatoonRepository extends JpaRepository<Platoon, UUID> {
}

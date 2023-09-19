package com.group.telegram_bot.repository;

import com.group.telegram_bot.model.Platoon;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatoonRepository extends JpaRepository<Platoon, UUID> {

}

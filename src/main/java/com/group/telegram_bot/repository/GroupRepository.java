package com.group.telegram_bot.repository;

import com.group.telegram_bot.model.Group;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, UUID> {
    Optional<Group> findByNumber(int groupNumber);
}

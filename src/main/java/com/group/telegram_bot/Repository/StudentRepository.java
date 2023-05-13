package com.group.telegram_bot.Repository;

import com.group.telegram_bot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
        Optional<Student> findStudentBySurname(String surname);

        @Query(nativeQuery = true, value = "SELECT name, stud_id, squad_id, surname, patronymic, dob, addr, phone, uni_id, uni_group FROM Student a WHERE a.stud_id = :stud_id")
        Optional<StudentFullDataProjection> findByDataById(String stud_id);
}

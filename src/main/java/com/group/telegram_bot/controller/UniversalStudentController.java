package com.group.telegram_bot.controller;

import com.group.telegram_bot.dto.AttendanceDto;
import com.group.telegram_bot.dto.lessons.FullLessonsDto;
import com.group.telegram_bot.dto.student.AuthorizeStudentDto;
import com.group.telegram_bot.dto.student.CreateStudentDto;
import com.group.telegram_bot.dto.student.FullStudentDto;
import com.group.telegram_bot.dto.studentFamily.CreateStudentFamilyDto;
import com.group.telegram_bot.mapper.LessonsMapper;
import com.group.telegram_bot.mapper.StudentMapper;
import com.group.telegram_bot.service.ClubService;
import com.group.telegram_bot.service.GroupService;
import com.group.telegram_bot.service.StudentFamilyService;
import com.group.telegram_bot.service.StudentLessonService;
import com.group.telegram_bot.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/universal/student")
@RequiredArgsConstructor
public class UniversalStudentController {

    private final StudentService studentService;
    private final StudentMapper studentMapper;
    private final StudentFamilyService studentFamilyService;
    private final GroupService groupService;
    private final ClubService clubService;
    private final StudentLessonService studentLessonService;
    private final LessonsMapper lessonsMapper;

    @PostMapping(path = ":authorize")
    public String authorizeStudent(@RequestBody AuthorizeStudentDto authorizeStudentDto) {
        return studentService.authorizeStudent(authorizeStudentDto);
    }

    @PostMapping(path = ":createAcc")
    public FullStudentDto createdStudentAccount(CreateStudentDto createStudentDto, HttpServletResponse response) {
        return studentMapper.toFullDto(studentService.addNewStudent(createStudentDto, response));
    }

    @PutMapping(path = ":addFamilyMember")
    public void addStudentFamilyToStudent(@RequestParam(name = "studentId") UUID studentId,
                                          @RequestBody CreateStudentFamilyDto createStudentFamilyDto) {
        var studentFamily = studentFamilyService.addNewStudentFamily(createStudentFamilyDto);
        studentService.addStudentFamily(studentId, studentFamily);
    }

    @PutMapping(path = ":setStudentToGroup")
    public void setStudentToGroup(@RequestParam(name = "studentId") UUID studentId,
                                  @RequestParam(name = "groupId") UUID groupId) {
        groupService.addStudent(groupId, studentId);
    }

    @PutMapping(path = ":setStudentToClub")
    public void setStudentToClub(@RequestParam(name = "studentId") UUID studentId,
                                 @RequestParam(name = "clubId") UUID clubId) {
        clubService.addMember(clubId, studentId);
    }

    @PutMapping(path = ":skipLesson")
    public void skipLesson(@RequestParam(name = "studentId") UUID studentId,
                           @RequestParam(name = "lessonId") UUID lessonId,
                           @RequestParam(name = "cause") String cause) {
        studentLessonService.skipLesson(studentId, lessonId, cause);
    }

    @PutMapping(path = ":skipLessonsInPeriod")
    public void skipLessonsInPeriod(@RequestParam(name = "studentId") UUID studentId,
                                    @RequestParam(name = "cause") String cause,
                                    @RequestParam(name = "from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime from,
                                    @RequestParam(name = "to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime to) {
        studentLessonService.skipLessonsInPeriod(studentId, cause, from, to);
    }

    @GetMapping(path = ":getNearestLessons")
    public List<FullLessonsDto> getNearestLessons(@RequestParam(name = "studentId") UUID studentId) {
        return lessonsMapper.toListLessonsDto(studentLessonService.getNearestLessons(studentId));
    }

    @GetMapping(path = ":getAttendance")
    public List<AttendanceDto> getAttendance(@RequestParam(name = "studentId") UUID studentId) {
        return studentLessonService.getAttendance(studentId);
    }
}

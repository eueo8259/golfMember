package com.example.golfMember.service;

import com.example.golfMember.dto.LessonDto;
import com.example.golfMember.entity.Lesson;
import com.example.golfMember.entity.Member;
import com.example.golfMember.entity.Teacher;
import com.example.golfMember.repository.LessonRepository;
import com.example.golfMember.repository.MemberRepository;
import com.example.golfMember.repository.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
@Slf4j
public class LessonService {
    private final LessonRepository lessonRepository;
    private final MemberRepository memberRepository;
    private final TeacherRepository teacherRepository;

    public LessonService(LessonRepository lessonRepository, MemberRepository memberRepository, TeacherRepository teacherRepository) {
        this.lessonRepository = lessonRepository;
        this.memberRepository = memberRepository;
        this.teacherRepository = teacherRepository;
    }

    public List<LessonDto> memberAll() {

//        List<Map<String, Object>> test = new ArrayList<>();
//
//        // 첫 번째 Map 생성 및 추가
//        Map<String, Object> map1 = new HashMap<>();
//        map1.put("name", "Alice");
//        map1.put("age", 30);
//        test.add(map1);
//
//        // 두 번째 Map 생성 및 추가
//        Map<String, Object> map2 = new HashMap<>();
//        map2.put("name", "Bob");
//        map2.put("age", 25);
//        test.add(map2);
//
//        // List<Map<String, Object>> 내용 출력
//        for (Map<String, Object> map : test) {
//            System.out.println("Name: " + map.get("name") + ", Age: " + map.get("age"));
//        } list map 공부 예시


        List<LessonDto> lessonDtoList = new ArrayList<>();
        List<Lesson> lessonList = lessonRepository.findAll();
        for (Lesson lesson : lessonList) {

            Member member = memberRepository.findById(lesson.getClassNo()).orElse(null);
            Teacher teacher = teacherRepository.findById(lesson.getClassTeacherId()).orElse(null);


            if (member != null & teacher != null){
                LessonDto lessonDto =LessonDto.fromLessonEntity(lesson);
                lessonDto.getMemberDto().setMemberId(member.getMemberId());
                lessonDto.getMemberDto().setMemberName(member.getMemberName());
                lessonDto.getMemberDto().setGrade(member.getGrade());
                lessonDto.getTeacherDto().setTeacherId(teacher.getTeacherId());
                lessonDto.getTeacherDto().setClassName(teacher.getClassName());
                lessonDtoList.add(lessonDto);
            }
        }
        return lessonDtoList;
    }

    public void insertClass(LessonDto dto) {
        Lesson lesson = Lesson.builder()
                .classId(dto.getClassId())
                .registMonth(dto.getRegistMonth())
                .classNo(dto.getClassNo())
                .classArea(dto.getClassArea())
                .tuition(dto.getTuition())
                .classTeacherId(dto.getClassTeacherId())
                .build();
        lessonRepository.save(lesson);
    }
    public Long searchNameId(String classNo){
        return lessonRepository.searchId(classNo);
    }
}

package com.example.golfMember.dto;

import com.example.golfMember.entity.Lesson;
import com.example.golfMember.entity.Member;
import com.example.golfMember.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LessonDto {
    private Long classId;
    private String registMonth;
    private String classNo; //MemberDto memberId와 값이 같음
    private String classArea;
    private int tuition;
    private String classTeacherId; //TeacherDto teacherId와 값이 같음
    private MemberDto memberDto;
    private TeacherDto teacherDto;



    public static LessonDto fromLessonEntity(Lesson lesson){
        MemberDto memberDto = new MemberDto();
        TeacherDto teacherDto = new TeacherDto();
        return new LessonDto(
                lesson.getClassId(),lesson.getRegistMonth(),lesson.getClassNo(),lesson.getClassArea(),lesson.getTuition()
                ,lesson.getClassTeacherId(),
                memberDto,
                teacherDto
        );
    }

}

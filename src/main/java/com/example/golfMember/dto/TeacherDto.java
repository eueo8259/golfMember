package com.example.golfMember.dto;

import com.example.golfMember.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherDto {
    private String teacherId;
    private String teacherName;
    private String className;
    private int classPrice;
    private String certificationDate;

    public static TeacherDto fromTeacherEntity(Teacher teacher){
        return new TeacherDto(
                teacher.getTeacherId(),teacher.getTeacherName(),teacher.getClassName(),
                teacher.getClassPrice(),teacher.getCertificationDate()
        );
    }
}

package com.example.golfMember.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "class")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Lesson {
    @Id
    @Column(name = "class_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classId;
    @Column(name = "regist_month", length = 6)
    private String registMonth;
    @Column(name = "class_no", length = 5)
    private String classNo; //memberId랑 fk
    @Column(name = "class_area", length = 15)
    private String classArea;
    private int tuition;
    @Column(name = "teacher_code", length = 3)
    private String classTeacherId; //teacherId랑 fk
}

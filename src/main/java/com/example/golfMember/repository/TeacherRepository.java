package com.example.golfMember.repository;

import com.example.golfMember.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, String> {
    @Query(value = "SELECT t.teacher_code,\n" +
            "       t.class_name,\n" +
            "       t.teacher_name,\n" +
            "       SUM(c.tuition) AS class_price,\n" +
            "t.teacher_gegist_date\n" +
            "FROM teacher t\n" +
            "LEFT JOIN class c ON t.teacher_code = c.teacher_code\n" +
            "GROUP BY t.teacher_code, t.class_name, t.teacher_name,t.teacher_gegist_date" , nativeQuery = true)
    List<Teacher> salesStatus();
}

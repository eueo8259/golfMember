package com.example.golfMember.repository;

import com.example.golfMember.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

    @Query(value = "select class_id from class where class_no = :classNo" ,nativeQuery = true)
    Long searchId(@Param("classNo") String classNo);
}

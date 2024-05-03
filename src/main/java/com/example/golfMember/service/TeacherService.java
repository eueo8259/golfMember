package com.example.golfMember.service;

import com.example.golfMember.dto.TeacherDto;
import com.example.golfMember.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<TeacherDto> showAll() {
        List<TeacherDto> studentDtoList = new ArrayList<>();
        return teacherRepository.findAll().stream()
                .map(x -> TeacherDto.fromTeacherEntity(x)).toList();
    }

    public List<TeacherDto> teacherSalesStatus() {
        List<TeacherDto> teacherDtoList1 = new ArrayList<>();
        teacherDtoList1 = teacherRepository.salesStatus().stream()
                .map(x -> TeacherDto.fromTeacherEntity(x))
                .toList();
        return teacherDtoList1;
    }
}

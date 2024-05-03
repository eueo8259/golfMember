package com.example.golfMember.controller;

import com.example.golfMember.dto.LessonDto;
import com.example.golfMember.dto.MemberDto;
import com.example.golfMember.dto.TeacherDto;
import com.example.golfMember.service.LessonService;
import com.example.golfMember.service.MemberService;
import com.example.golfMember.service.TeacherService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
public class GolfMemberController {
    private final LessonService lessonService;
    private final MemberService memberService;
    private final TeacherService teacherService;

    public GolfMemberController(LessonService lessonService, MemberService memberService, TeacherService teacherService) {
        this.lessonService = lessonService;
        this.memberService = memberService;
        this.teacherService = teacherService;
    }

    @GetMapping("memberList")
    public String LessonAll(Model model){
        List<LessonDto> LessonDtoList = lessonService.memberAll();
        model.addAttribute("lessonDto", LessonDtoList);

//        List<Integer> studentRankList = examService.studentRank();
//        model.addAttribute("studentRank", studentRankList);

        return "articles/memberList";
    }

    @GetMapping("list")
    public String studentListAll(Model model){
        List<TeacherDto> teacherDtoList = teacherService.showAll();
        model.addAttribute("teacherDto", teacherDtoList);
        return "/articles/teacherListAll";
    }

    @GetMapping("insert")
    public String insertMember(Model model){
        //post로 받아올 빈 깡통 LessonDto보내기
        LessonDto lessonDto = new LessonDto();
        model.addAttribute("lessonDto", lessonDto);

        List<MemberDto> memberNameList = memberService.membersAll();
        model.addAttribute("memberNameList", memberNameList);

        List<TeacherDto> classNameList = teacherService.showAll();
        model.addAttribute("classNameList", classNameList);
        return "/articles/insertView";
    }
    @PostMapping("insert")
    public String insertArticle(@Valid @ModelAttribute("lessonDto") LessonDto dto,
                                @RequestParam("classNo") String classNo
            , BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "articles/insertView";
        }
        Long id = lessonService.searchNameId(classNo);
        log.info("================================");
        log.info(String.valueOf(id));
        dto.setClassId(id);
        lessonService.insertClass(dto);
        return "redirect:/"; //post처리하고 다시 보여주는 페이지로
    }
    @GetMapping("salesStatus")
    public String salesStatus(Model model){
        List<TeacherDto>teacherDtoList = teacherService.teacherSalesStatus();
        model.addAttribute("teacherDtoList", teacherDtoList);
        return "articles/salesStatus";
    }

}

package com.example.golfMember.dto;

import com.example.golfMember.entity.Member;
import com.example.golfMember.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDto {
    private String memberId;
    private String memberName;
    private String phone;
    private String address;
    private String grade;

    public static MemberDto fromMemberEntity(Member member){
        return new MemberDto(
                member.getMemberId(),member.getMemberName(),member.getPhone(),
                member.getAddress(),member.getGrade()
        );
    }
}

package com.icia.member.DTO;

import com.icia.member.Entity.MemberEntity;
import lombok.Data;

@Data

public class MemberDTO {
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
    private String memberBirth;
    private String memberMobile;

    public static MemberDTO toList(MemberEntity memberEntity) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(memberEntity.getId());
        memberDTO.setMemberEmail(memberEntity.getMemberEmail());
        memberDTO.setMemberPassword(memberEntity.getMemberPassword());
        memberDTO.setMemberName(memberEntity.getMemberName());
        memberDTO.setMemberBirth(memberEntity.getMemberBirth());
        memberDTO.setMemberMobile(memberEntity.getMemberMobile());
        return memberDTO;
    }

}

package com.icia.member.Entity;

import com.icia.member.DTO.MemberDTO;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "member_table")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String memberEmail;

    @Column(length = 20, nullable = false)
    private String memberPassword;

    @Column(length = 20, nullable = false)
    private String memberName;

    @Column(length = 20)
    private String memberBirth;

    @Column(length = 30)
    private String memberMobile;

    public static MemberEntity toSaveEntity(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
        memberEntity.setMemberPassword(memberDTO.getMemberPassword());
        memberEntity.setMemberName(memberDTO.getMemberName());
        memberEntity.setMemberBirth(memberDTO.getMemberBirth());
        memberEntity.setMemberMobile(memberDTO.getMemberMobile());
        return memberEntity;
    }
    public static MemberEntity toUpdateEntity(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberEntity.toSaveEntity(memberDTO);
        memberEntity.setId(memberDTO.getId());
        return memberEntity;
    }
}

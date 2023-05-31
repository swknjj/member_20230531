package com.icia.member.Repository;

import com.icia.member.Entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity,Long> {
    /*
    select => findBy
    select * from member_table where memberEmail = ?
     */
    Optional<MemberEntity> findByMemberEmail(String memberEmail);
    /*
    select * from member_table wher member_email=? and member_password = ?
     */
    Optional<MemberEntity> findByMemberEmailAndMemberPassword(String memberEmail, String memberPassword);


}

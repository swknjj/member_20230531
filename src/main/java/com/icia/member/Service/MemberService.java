package com.icia.member.Service;

import com.icia.member.DTO.MemberDTO;
import com.icia.member.Entity.MemberEntity;
import com.icia.member.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Long save(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberEntity.toSaveEntity(memberDTO);
        return memberRepository.save(memberEntity).getId();
    }

    public Optional<MemberEntity> login(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberEntity.toSaveEntity(memberDTO);
        Optional<MemberEntity> entity = memberRepository.findByMemberEmailAndMemberPassword(memberEntity.getMemberEmail(),memberEntity.getMemberPassword());
        return entity;
    }

    public List<MemberDTO> findAll() {
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        List<MemberDTO> memberDTOList = new ArrayList<>();
        for(MemberEntity memberEntity: memberEntityList) {
            memberDTOList.add(MemberDTO.toList(memberEntity));
        }
        return memberDTOList;
    }

    public MemberDTO findById(Long id) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findById(id);
        if(optionalMemberEntity.isPresent()){
            System.out.println("있다");
            return MemberDTO.toList(optionalMemberEntity.get());
        }else {
            System.out.println("없다");
            return null;
        }
    }

    public void delete(Long id) {
        memberRepository.deleteById(id);
    }

    public void update(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberEntity.toUpdateEntity(memberDTO);
        memberRepository.save(memberEntity);
    }
}

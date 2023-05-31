package com.icia.member.Controller;

import com.icia.member.DTO.MemberDTO;
import com.icia.member.Entity.MemberEntity;
import com.icia.member.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/member/save")
    public String memberSave() {
        return "/MemberPages/memberSave";
    }

    @PostMapping("/member/save")
    public String memeberSave(@ModelAttribute MemberDTO memberDTO) {
        memberService.save(memberDTO);
        return "/MemberPages/memberLogin";
    }

    @GetMapping("/member/login")
    public String loginForm() {
        return "/MemberPages/memberLogin";
    }

    @PostMapping("/member/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
        Optional<MemberEntity> entity = memberService.login(memberDTO);
        if (entity.isPresent()) {
            session.setAttribute("memberEmail", memberDTO.getMemberEmail());
            return "/MemberPages/memberMain";
        }
        return "/MemberPages/memberLogin";
    }



    @GetMapping("/member/")
    public String members(Model model) {
        List<MemberDTO> memberDTOList = memberService.findAll();
        model.addAttribute("member",memberDTOList);
        return "/MemberPages/memberList";
    }


    @GetMapping("/member/{id}")
    public String memberDetail(@PathVariable Long id,Model model) {
        MemberDTO memberDTO = memberService.findById(id);
        model.addAttribute("member",memberDTO);
        return "/MemberPages/memberDetail";
    }

    @GetMapping("/member/update/{id}")
    public String memberUpdateForm(@PathVariable Long id, Model model) {
        MemberDTO memberDTO = memberService.findById(id);
        model.addAttribute("member",memberDTO);
        return "/MemberPages/memberUpdate";
    }

    @PostMapping("/member/update")
    public String memberUpdate(@ModelAttribute MemberDTO memberDTO) {
        memberService.update(memberDTO);
        return "redirect:/member/" + memberDTO.getId();
    }




    @GetMapping("/member/delete/{id}")
    public String memeberDelete(@PathVariable Long id) {
        memberService.delete(id);
        return "redirect:/member/";
    }
}

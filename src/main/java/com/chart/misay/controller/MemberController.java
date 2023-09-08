package com.chart.misay.controller;

import com.chart.misay.dto.MisayDTO;
import com.chart.misay.service.MisayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.management.MemoryNotificationInfo;

@Controller
@RequiredArgsConstructor
public class MemberController {
    final MisayService misayService;
    @GetMapping("/createMember")
    public String createMember(){
        return "createMember";
    }

    @PostMapping("/member")
    public String member(@ModelAttribute MisayDTO dto){
        misayService.member(dto);
        return "redirect:/index";
    }
    @GetMapping("/membership")
    public String membership(Model model){
        model.addAttribute("list",misayService.getMembers());
        return "membership";
    }

    @GetMapping("/searchMember")
    public String searchMember(@RequestParam("keyword") String keyword, Model model){
        model.addAttribute("list",misayService.searchMembers(keyword));
        return "membership";
    }

    @GetMapping("/memberDetail")
    public String memberDetail(@RequestParam("name") String name,
                               @RequestParam("mno") Long mno,
                               Model model){
        model.addAttribute("member",misayService.getMisayDTO(mno));
        model.addAttribute("list", misayService.getName(name));
        return "memberDetail";
    }
    @GetMapping("/register")
    public String register(@RequestParam("name") String name,
                           @RequestParam("age")String age,
                           @RequestParam("mno") Long mno,
                           Model model){
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        model.addAttribute("mno", mno);
        return "register";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute MisayDTO dto){
        System.out.println(dto);
        misayService.register(dto);
        return "redirect:index";
    }
    @GetMapping("/memberChange")
    public String memberChange(@RequestParam("name") String name, @RequestParam("age") String age, @RequestParam("mno") Long mno, Model model){
        model.addAttribute("mno", mno);
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "memberChange";
    }
}

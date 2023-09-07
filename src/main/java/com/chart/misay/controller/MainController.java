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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final MisayService misayService;

    private List<MisayDTO> searchResults = new ArrayList<>(); // 검색 결과를 저장할 변수
    @GetMapping({"","index.html","index"})
    public String index(Model model){
        model.addAttribute("list",misayService.getList());
        return "index";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute MisayDTO dto){
        misayService.register(dto);
        return "redirect:index";
    }
    @GetMapping("/detail")
    public String detail(@RequestParam("bno") Long bno, Model model){
        model.addAttribute("list",misayService.read(bno));
        return "detail";
    }
    @GetMapping("/search")
    public String search(@RequestParam("search") String keyword, Model model){
        model.addAttribute("list", misayService.getSearch(keyword));
        return "search";
    }

}

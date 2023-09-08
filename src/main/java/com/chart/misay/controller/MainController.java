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

@Controller
@RequiredArgsConstructor
public class MainController {

    private final MisayService misayService;

    @GetMapping({"","index.html","index"})
    public String index(Model model){
        model.addAttribute("list",misayService.getList());
        return "index";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("bno") Long bno, Model model){
        model.addAttribute("list",misayService.read(bno));
        return "detail";
    }
    @GetMapping("/search")
    public String search(@RequestParam("keyword") String keyword,
                         @RequestParam("searchOption") String searchOption, Model model){
        if ("surgeryName".equals(searchOption)) {
            model.addAttribute("list", misayService.getSurgery(keyword));
        } else if ("name".equals(searchOption)) {
            model.addAttribute("list", misayService.getName(keyword));
        }
        return "search";
    }

}

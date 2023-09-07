package com.chart.misay.controller;

import com.chart.misay.service.MisayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class CategoryController {

    final MisayService misayService;

    @GetMapping("/cx")
    public String cx(@RequestParam("value") String value, Model model){
        model.addAttribute("list", misayService.getCategory(value));
        return "index";
    }
    @GetMapping("/sh")
    public String sh(@RequestParam("value") String value, Model model){
        model.addAttribute("list", misayService.getCategory(value));
        return "index";
    }
    @GetMapping("/elbow")
    public String elbow(@RequestParam("value") String value, Model model){
        model.addAttribute("list", misayService.getCategory(value));
        return "index";
    }
    @GetMapping("/lx")
    public String lx(@RequestParam("value") String value, Model model){
        model.addAttribute("list", misayService.getCategory(value));
        return "index";
    }
    @GetMapping("/knee")
    public String knee(@RequestParam("value") String value, Model model){
        model.addAttribute("list", misayService.getCategory(value));
        return "index";
    }
    @GetMapping("/ankle")
    public String ankle(@RequestParam("value") String value, Model model){
        model.addAttribute("list", misayService.getCategory(value));
        return "index";
    }

}

package com.first.firstone.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.Getter;
import lombok.Setter;

@Controller
public class ThymeleafTestController {
    
    @GetMapping("/thymeleaf/test")
    public String thymeleafTest(Model model){
        Person examplePerson = new Person();
        examplePerson.setId(1L);
        examplePerson.setAge(14);
        examplePerson.setName("희");
        examplePerson.setHobbies(List.of("테니스", "골프", "펜싱", "운동"));

        model.addAttribute("person", examplePerson);
        model.addAttribute("today", LocalDate.now());

        return "test"; // call test.html in templates 
    }

    @Setter
    @Getter
    class Person {
        private Long id;
        private String name;
        private int age;
        private List<String> hobbies;
    }
}

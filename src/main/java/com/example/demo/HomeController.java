package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/")
    public String index(Model model) {
        Person person1 = new Person();
        person1.setName("Austin");
        person1.setAge("24");
        person1.setHeight("5'8\"");
        personRepository.save(person1);

        Person person2 = new Person();
        person2.setName("Carlos");
        person2.setAge("20");
        person2.setHeight("5'2\"");
        personRepository.save(person2);

        model.addAttribute("people", personRepository.findAll());
        return "index";
    }

    @RequestMapping("/search")
    public String search(@RequestParam("search") String search, Model model) {
        model.addAttribute("peopleSearch", personRepository.findByName(search) );
        return "searchlist";
    }

}

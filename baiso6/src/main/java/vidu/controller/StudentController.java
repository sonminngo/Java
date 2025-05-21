package vidu.controller;

import vidu.model.Student;
import vidu.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepo;

    @GetMapping("/students")
    public String listStudents(Model model,
                               @RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "") String keyword) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Student> studentPage = studentRepo.findByNameContainingOrEmailContaining(keyword, keyword, pageable);

        model.addAttribute("studentPage", studentPage);
        model.addAttribute("keyword", keyword);
        model.addAttribute("currentPage", page);

        return "students";
    }
}

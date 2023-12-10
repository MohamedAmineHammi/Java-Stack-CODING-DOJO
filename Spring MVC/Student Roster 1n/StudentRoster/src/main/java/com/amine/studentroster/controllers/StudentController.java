package com.amine.studentroster.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amine.studentroster.models.Dorm;
import com.amine.studentroster.models.Student;
import com.amine.studentroster.services.DormService;
import com.amine.studentroster.services.StudentService;

import jakarta.validation.Valid;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentServ;
	@Autowired
	private DormService dormServ;

//	Display Route - Display all students | Create student Form
	@GetMapping("/students/new")
	public String stud(Model model, @ModelAttribute("student") Student student) {

		List<Student> all_students = studentServ.allStudents();
		model.addAttribute("students", all_students);

		// Get All Dorms
		List<Dorm> all_dorms = dormServ.allDorms();
		model.addAttribute("all_dorms", all_dorms);
		return "create_student.jsp";

	}

	@PostMapping("/students/new")
	public String createStudent(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model) {

		if (result.hasErrors()) {
			List<Student> all_students = studentServ.allStudents();
			model.addAttribute("students", all_students);
			return "create_student.jsp";
		} else {
			Student newStudent = studentServ.createStudent(student);
			return "redirect:/dorms";
		}

	}

// ACTION ROUTE -- DELET a Student

	@PostMapping("/students/delete/{id}")
	public String delete(@PathVariable("id") Long id, @RequestParam("dormId") Long dormId, Model model) {
		studentServ.deleteStudent(id);
		return "redirect:/dorms/" + dormId;
	}

	// Action Route -- Edit a Student

	@PutMapping("/students/edit/{id}")
	public String updateStudent(@Valid @ModelAttribute("student") Student student, 
			BindingResult result, @PathVariable("id") Long id, 
			@RequestParam("dormId") Long dormId, Model model) {


			studentServ.updateStudent(student);
			return "redirect:/dorms/" + dormId;
		}
	}



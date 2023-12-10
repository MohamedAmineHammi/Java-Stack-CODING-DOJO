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
import org.springframework.web.bind.annotation.RequestParam;

import com.amine.studentroster.models.Dorm;
import com.amine.studentroster.models.Student;
import com.amine.studentroster.services.DormService;
import com.amine.studentroster.services.StudentService;

import jakarta.validation.Valid;

@Controller
public class DormController {
	@Autowired
	private DormService dormServ;

	@GetMapping("/dorms")
	public String index(Model model, @ModelAttribute("dorm") Dorm dorm) {

		List<Dorm> all_dorms = dormServ.allDorms();
		model.addAttribute("dorms", all_dorms);
		return "display_dorm.jsp";
	}

	@GetMapping("/dorms/new")
	public String dorms(@ModelAttribute("dorm") Dorm dorm) {
		return "create_dorm.jsp";
	}

//	Action Route - Create a Dorm
	@PostMapping("/dorms")
	public String createDorm(@Valid @ModelAttribute("dorm") Dorm dorm, BindingResult result, Model model) {

		if (result.hasErrors()) {
			List<Dorm> all_dorms = dormServ.allDorms();
			model.addAttribute("dorms", all_dorms);
			return "create_dorm.jsp";
		} else {
			Dorm newDorm = dormServ.createDorm(dorm);
			return "redirect:/dorms";
		}

	}




	@Autowired
	private StudentService studentServ;

	@GetMapping("/dorms/{id}")
	public String one_dorm_students(@PathVariable("id") Long id, Model model) {
		Dorm selected_dorm = dormServ.findDorm(id);
		model.addAttribute("dorm", selected_dorm);

		List<Student> students = studentServ.allStudents();
		model.addAttribute("students", students);

		return "one_dorm.jsp";
	}


	@PostMapping("/dorms/{dormId}/addStudent")
	public String addStudentToDorm(@PathVariable("dormId") Long dormId, @RequestParam("studentId") Long studentId) {
		dormServ.addStudentToDorm(dormId, studentId);
		return "redirect:/dorms/" + dormId;
	}
}
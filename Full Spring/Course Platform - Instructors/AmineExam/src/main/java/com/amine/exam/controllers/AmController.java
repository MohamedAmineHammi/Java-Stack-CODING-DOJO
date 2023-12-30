package com.amine.exam.controllers;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.amine.exam.models.Course;
import com.amine.exam.models.LoginUser;
import com.amine.exam.models.Student;
import com.amine.exam.models.User;
import com.amine.exam.services.CourseService;
import com.amine.exam.services.StudentService;
import com.amine.exam.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class AmController {
	@Autowired
	private UserService userServ;

	@Autowired
	CourseService courseService;

	@Autowired
	StudentService studentService;

	@GetMapping("/")
	public String index(Model model) {

		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
			HttpSession session) {

		userServ.register(newUser, result);

		if (result.hasErrors()) {

			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}

		session.setAttribute("userId", newUser.getId());

		return "redirect:/home";
	}

	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
			HttpSession session) {

		User user = userServ.login(newLogin, result);

		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}

		session.setAttribute("userId", user.getId());

		return "redirect:/home";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("userId", null);

		return "redirect:/";
	}

	@GetMapping("/home")
	public String home(Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}

		User user = userServ.findById(userId);
		List<Course> courses = courseService.allCourses();
		model.addAttribute("courses", courses);
		model.addAttribute("user", user);
		return "dashboard.jsp";
	}

	// Create New Course
	@GetMapping("/courses/new")
	public String newCourse(@ModelAttribute("course") Course course, Model model, HttpSession session) {

		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}

		User user = userServ.findById(userId);
		model.addAttribute("user", user);

		return "new_course.jsp";
	}

	@PostMapping("/new/course")
	public String createCourse(@Valid @ModelAttribute("course") Course course, BindingResult result, Model model,
			HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}

		User user = userServ.findById(userId);
		model.addAttribute("user", user);
		if (result.hasErrors()) {
			return "new_course.jsp";
		} else {
			courseService.createCourse(course);
			return "redirect:/home";
		}
	}

	public LocalTime parseTime(String timeString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		return LocalTime.parse(timeString, formatter);
	}

	// Create Student
	@PostMapping("/new/student")
	public String createStudent(@Valid @ModelAttribute("student") Student student, BindingResult studentBindingResult,
			@RequestParam("courseId") Long courseId, Model model, HttpSession session) {

		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}

		if (studentBindingResult.hasErrors()) {
			User user = userServ.findById(userId);
			Course course = courseService.findCourse(courseId);
			model.addAttribute("course", course);
			model.addAttribute("user", user);
			List<Student> courseStudents = studentService.getStudentsByCourseId(course);
			model.addAttribute("students", courseStudents);

			return "show_course.jsp";
		} else {
			Course course = courseService.findCourse(courseId);

			Integer studentCount = course.getStudentsCount();
			course.setStudentsCount(studentCount += 1);
			student.setCourse(course);
			studentService.createStudent(student);
			courseService.updateCourse(course);
			return "redirect:/courses/" + courseId;
		}
	}

	// Show Course

	@GetMapping("/courses/{courseId}")
	public String oneCourse(Model model, @PathVariable("courseId") Long courseId, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}

		User user = userServ.findById(userId);
		model.addAttribute("user", user);

		Student student = new Student();
		model.addAttribute("student", student);

		Course course = courseService.findCourse(courseId);
		model.addAttribute("course", course);

		List<Student> courseStudents = studentService.getStudentsByCourseId(course);
		model.addAttribute("students", courseStudents);

		return "show_course.jsp";
	}

	// Edit Course

	@RequestMapping("/courses/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}

		User user = userServ.findById(userId);

		Course course = courseService.findCourse(id);
		if (course != null) {
			model.addAttribute("user", user);
			model.addAttribute("course", course);
			return "edit_course.jsp";
		}

		else
			return "redirect:/home";
	}

	@RequestMapping(value = "/courses/edit/{id}", method = RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("course") Course course, BindingResult result) {
		if (result.hasErrors()) {
			return "edit_course.jsp";
		} else {
			courseService.updateCourse(course);
			return "redirect:/home";
		}
	}

	// Delete Course
	@RequestMapping("/delete/{courseId}")
	public String deleteCourse(@PathVariable("courseId") Long courseId) {

		studentService.deleteStudentsByCourseId(courseId);
		courseService.deleteCourse(courseId);

		return "redirect:/home";

	}

}
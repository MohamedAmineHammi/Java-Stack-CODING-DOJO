package com.coding.dojo.controllers;

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

import com.coding.dojo.models.LoginUser;
import com.coding.dojo.models.Project;
import com.coding.dojo.models.Task;
import com.coding.dojo.models.User;
import com.coding.dojo.services.AppService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class AppController {
	@Autowired
    private AppService appServ;
	
	
	@GetMapping("/")
    public String index(Model model) {
		
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "login.jsp";
    }
	
	@PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        appServ.register(newUser, result);
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "login.jsp";
        }
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/dashboard";
    }
	
	
	@PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        User user = appServ.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "login.jsp";
        }
        session.setAttribute("user_id", user.getId());
        return "redirect:/dashboard";
    }
	
	@GetMapping("/logout")
    public String logout(HttpSession session) {
		session.removeAttribute("user_id");
		return "redirect:/";
	}
	
	@GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {
		if (session.getAttribute("user_id") != null) {
    	Long user_id = (Long) session.getAttribute("user_id");
    	User thisUser = appServ.findUser(user_id);
        model.addAttribute("thisUser", thisUser);
        model.addAttribute("notActiveProjects", appServ.findProjectsNotRelatedToUser(user_id));
        return "dashboard.jsp";
        }
		else {
			return "redirect:/";
		}
    }
	

	
	@GetMapping("/projects/new")
		public String create( @ModelAttribute("project") Project project) {
			return "createProject.jsp";
		}
	
	@PostMapping("/newproject")
    public String createProject(@Valid @ModelAttribute("project") Project project, BindingResult result) {
        if (result.hasErrors()) {
            return "createProject.jsp";
        } else {
            appServ.createProject(project);
            return "redirect:/dashboard";
        }
    }
	@GetMapping("/join/{id}")
	public String join(@PathVariable("id") Long id,HttpSession session) {
		Project project = appServ.findProject(id);
		Long user_id = (Long) session.getAttribute("user_id");
    	User thisUser = appServ.findUser(user_id);
    	project.getTeamMembers().add(thisUser);
    	appServ.updateProject(project);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/leave/{id}")
	public String leave(@PathVariable("id") Long id,HttpSession session) {
		Project project = appServ.findProject(id);
		Long user_id = (Long) session.getAttribute("user_id");
    	User thisUser = appServ.findUser(user_id);
    	project.getTeamMembers().remove(thisUser);
    	appServ.updateProject(project);
		return "redirect:/dashboard";
	}
	
	
	

	
	@GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id,Model model) {
         Project project = appServ.findProject(id);
         model.addAttribute("project",project);
         return "edit.jsp";
    }

    @RequestMapping(value="/handle/{id}",method=RequestMethod.PUT)
    public String editing(@Valid @ModelAttribute("project") Project project,BindingResult result,Model model) {
        if (result.hasErrors()) {
             model.addAttribute("project",project);
             return "edit.jsp";
        } else {
            appServ.updateProject(project);
            return "redirect:/dashboard";
        }
    }
    
    
   @GetMapping("/projects/{id}")
   public String view(@PathVariable("id") Long id,Model model) {
	   Project project = appServ.findProject(id);
	   model.addAttribute("proj", project);
	   return "view.jsp";
   }
	
   @GetMapping("/delete/{id}")
   public String destroy(@PathVariable("id") Long id) {
    appServ.deleteProject(id);
       return "redirect:/dashboard";
   }
   
   @GetMapping("/projects/{id}/tasks")
   public String tasks(@PathVariable("id") Long id,@ModelAttribute("task") Task task,Model model) {
	   Project project = appServ.findProject(id);
	   model.addAttribute("proj", project);
       return "task.jsp";
   }
   
   
   @PostMapping("/newtask/{id}")
   public String createTask(@Valid @ModelAttribute("task") Task task, BindingResult result,@PathVariable("id") Long id,Model model) {
       if (result.hasErrors()) {
    	   Project project = appServ.findProject(id);
    	   model.addAttribute("proj", project);
           return "task.jsp";
       } else {
           appServ.createTask(task);
           return "redirect:/projects/"+id+"/tasks";
       }
   }
   
   
}

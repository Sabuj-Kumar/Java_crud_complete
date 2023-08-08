package com.javaSpring.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.javaSpring.entity.Employee;
import com.javaSpring.service.EmployeeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService empService;
	
	@GetMapping("/")
	public String home(Model m) {
		
		List<Employee> list = empService.getAll();
		m.addAttribute("data", list);
		return "index";
	}
	
	@GetMapping("/addemp")
	public String addEmployee() {
		return "add_emp";
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e,HttpSession session) {
		System.out.println(e);
		empService.addEmployee(e);
		session.setAttribute("msg", "Data added succesfully.");
		return "add_emp";
	}
	@GetMapping("/edit/{id}")
	public String editEmployee(@PathVariable int id, Model m) {
		System.out.println(id);
		Employee e = empService.getEmployeeById(id);
		m.addAttribute("emp",e);
		System.out.println(e);
		return "edit";
	}
	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute Employee e,HttpSession session) {
		
		empService.addEmployee(e);
		session.setAttribute("msg", "Data update succesfully.");
		return "redirect:/";
	}
	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
	
		empService.deleteEmployeeById(id);
		return "redirect:/";
	}
	
}

package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.entity.Student;
import com.demo.service.StudentService;
import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;
    
    @GetMapping("/")
    public String home(Model model) {
       
        return "index";
    }
    
    @GetMapping("/welcome.html")
    public String home2(Model model) {
    	return "welcome.html";
    }
    
    @GetMapping("/logout.html") 
	public String home3(Model model) { 
		  
		  return "logout.html";
    }
	 
    @GetMapping("/logout1.html") 
	public String home4(Model model) { 
		  
		  return "index.html";
	}
    
    @GetMapping("/signup.html") 
	public String home5(Model model) { 
		  
		  return "signup.html";
	}
	 
	
   
   @GetMapping("/Records.html")
   public String all(Model model) {
       List<Student> students = studentService.getAllStudents();
       model.addAttribute("students", students);
       return "Records";
   }
   
    
    @GetMapping("/addstudent")
	public String addStudentForm()
	{
		return "add_student";
	}
    
    @PostMapping("/addstudent")
	public String studRegister(@ModelAttribute Student e,HttpSession session)
	{
		System.out.println(e);
		studentService.addStudent(e);
	
		
		return "add_student";
	}
	
    @GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m)
	{
		
		Student e=studentService.getStudentById(id);
		m.addAttribute("students",e);
		
		return "edit";
	}
	
    @PostMapping("/{update}")
    public String updateStudent(@ModelAttribute Student e)
	{
    	studentService.addStudent(e);
		return "redirect:/";
	}
    
   
    @GetMapping("/delete/{id}")
    public String deleteStudentString(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "redirect:/";
    }
    
    
 
}
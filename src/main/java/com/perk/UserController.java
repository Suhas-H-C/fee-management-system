package com.perk;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	StudentRepository studentRepo;

	private static Logger logger = LoggerFactory.getLogger(UserController.class);

	private static final String PAGE_TITLE = "title";
	private static final String PAGE_CONDITION = "condition";
	private static final String UPDATE_STUDENT = "Update Student";

	@ModelAttribute
	private void commonData(Model m) {
		m.addAttribute("user", "Suhas");
	}

	@RequestMapping("/userdashboard")
	public String userDashboard(Model m) {
		m.addAttribute(PAGE_TITLE, "Dashboard");
		return "user/userdashboard";
	}
	@RequestMapping("/viewstudents")
	public String userStudentsView(Model m) {
		List<Students> allStudents = studentRepo.findAll();
		m.addAttribute("all", allStudents);
		logger.info("Student Data Accessed on {}",LocalDateTime.now());
		m.addAttribute(PAGE_TITLE, "Display Students");
		return "user/view";
	}

	@RequestMapping("/addstudents")
	public String userStudentAdd(Model m) {
		m.addAttribute(PAGE_TITLE, "Add Student");
		m.addAttribute(PAGE_CONDITION, false);
		m.addAttribute("added", new Students());
		return "user/add";
	}
	
	@PostMapping("/adding")
	public String getAddedStudent(StudentDTO stdd,Model m) {
		DtoConverter converter = new DtoConverter();
		Students dto = converter.getStudentObject(stdd);
		m.addAttribute(PAGE_CONDITION, true);
		m.addAttribute(PAGE_TITLE, "Add Student");
		m.addAttribute("msg", stdd.getFirstname()+"'s Record added succcessfully");
		m.addAttribute("added", new Students());
		logger.info("{}'s added to student database on {}",stdd.getFirstname(),LocalDateTime.now());
		studentRepo.save(dto);
		return "user/add";
	}

	@RequestMapping("/updatestudents")
	public String userStudentUpdate(Model m) {
		List<Students> allStudents = studentRepo.findAll();
		m.addAttribute("all", allStudents);
		m.addAttribute(PAGE_TITLE, UPDATE_STUDENT);
		m.addAttribute(PAGE_CONDITION, false);
		return "user/update";
	}

	@PostMapping("/updated")
	public String processStudentUpdation(@RequestParam("value") int id,Model m){
		Students byId = studentRepo.getById(id);
		m.addAttribute("constant", byId);
		m.addAttribute(PAGE_TITLE, UPDATE_STUDENT);
		return "user/updation";
	}

	@PostMapping("/afterupdate")
	public String getUpdatedStudent(StudentDTO studentDto,Model m) {
		DtoConverter converter = new DtoConverter();
		Students students = converter.getStudentObject(studentDto);
		m.addAttribute(PAGE_TITLE, UPDATE_STUDENT);
		m.addAttribute(PAGE_CONDITION, true);
		m.addAttribute("msg", students.getFirstname()+"'s Record updated succcessfully");
		logger.info("{}'s data updated on {}",students.getFirstname(),LocalDateTime.now());
		studentRepo.save(students);
		List<Students> allStudents = studentRepo.findAll();
		m.addAttribute("all", allStudents);
		return "user/update";
	}

	@RequestMapping("/showme")
	public String getApplicationUser(Model m) {
		m.addAttribute(PAGE_TITLE, "Profile");
		return "user/profile";
	}
	@RequestMapping("/remove")
	public String userStudentDeletion(Model m) {
		List<Students> allStudents = studentRepo.findAll();
		m.addAttribute("all", allStudents);
		m.addAttribute(PAGE_CONDITION, false);
		m.addAttribute(PAGE_TITLE, "Remove Student");
		return "user/remove";
	}
	@PostMapping("/removes")
	public String getRemovedStudent(@RequestParam(value = "id",required = true) int id,Model m) {
		Students byId = studentRepo.getById(id);
		logger.info("{}'s data erased on {}",byId.getFirstname(),LocalDateTime.now());
		studentRepo.deleteById(id);
		List<Students> allStudents = studentRepo.findAll();
		m.addAttribute("all", allStudents);
		m.addAttribute(PAGE_CONDITION, true);
		m.addAttribute("msg", byId.getFirstname()+" Removed succcessfully");
		return "user/remove";
	}
}

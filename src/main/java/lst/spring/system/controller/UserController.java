package lst.spring.system.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lst.spring.Entity.Role;
import lst.spring.Entity.User;
import lst.spring.Entity.UserFormat;
import lst.spring.system.calendar.CalendarService;
import lst.spring.system.service.UserService;

@Controller
@RequestMapping("/system/")
public class UserController{
	
	@Autowired
	private UserService userservice;

	@Autowired
	private CalendarService calendarservice;
	
	@GetMapping("/register")
	public String reg(UserFormat format, Model model) {
		model.addAttribute("format",format);
		return "system/register";
	}
	
	@PostMapping("/register")
	public String reg(@ModelAttribute("format")@Valid UserFormat format, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "system/register";
		}
		if(!format.getPassword1().equals(format.getPassword2())) {
			result.rejectValue("password2", "passwordInCorrect", "패스워드가 일치하지 않습니다.");
			return "system/register";
		}
		
		User user = new User();
		user.setId(format.getId());
		user.setPassword(format.getPassword1());
		user.setNickname(format.getNickname());
		user.setPhone(format.getPhone());
		user.setEmail(format.getEmail());
		user.setRole(Role.ROLE_USER);
		user.setEnabled(true);
		userservice.saveUser(user);
		model.addAttribute("format",format);
		return "redirect:/";
	}
	
	@RequestMapping("/main")
	public String main(Model model){
		List<List<Integer>> calendar = new ArrayList<List<Integer>>();
		calendar = calendarservice.calendarView();
		LocalDate now = LocalDate.now();
		int month = now.getMonth().getValue();
		
		System.out.println(calendar);
		
		
		model.addAttribute("month",month);
		model.addAttribute("calendar",calendar);
		return "system/main";
	}
	
	@RequestMapping("/calendar")
	public String nowCalendar(Model model) {
		
		return "system/calendar";
	}
	
}
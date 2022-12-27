package lst.spring.system.controller;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lst.spring.Entity.Role;
import lst.spring.Entity.SessionUser;
import lst.spring.Entity.User;
import lst.spring.Entity.UserFormat;
import lst.spring.system.service.UserService;

@Controller
@RequestMapping("/system/")
public class UserController{
	
	@Autowired
	private UserService userservice;
	
	private HttpSession httpSession;

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
		user.setRole(Role.USER);
		user.setEnabled(true);
		userservice.saveUser(user);
		model.addAttribute("format",format);
		return "redirect:/";
	}
	
	@RequestMapping("/main")
	public String main(Model model, HttpServletRequest request){
		LocalDate now = LocalDate.now();
		int year = now.getYear();
		int month = now.getMonth().getValue();
		httpSession = request.getSession();
		SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null) {
            model.addAttribute("userName", user.getName());
            model.addAttribute("userImg", user.getPicture());
        }
		
		model.addAttribute("month",month);
		model.addAttribute("year", year);
		return "system/main";
	}
	
	@RequestMapping("/mypage")
	public String veiwMyPage(Model model) {
		
		return "system/myPage";
	}
	
}
package lst.spring.calendar.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lst.spring.Entity.Plan;
import lst.spring.security.SecurityUser;
import lst.spring.system.calendar.CalendarService;


@Controller
@RequestMapping("/calendar/")
public class CalendarController {
	
	@Autowired
	private CalendarService calendarservice;
	
	@RequestMapping("/{year}/{month}")
	public String nowCalendar(Model model, @PathVariable int year, @PathVariable int month) {
		
		List<List<Integer>> calendar = new ArrayList<List<Integer>>();
		if(month==13) {
			month =1;
			year += 1;
		}
		if(month==0) {
			month = 12;
			year -= 1;
		}
		calendar = calendarservice.calendarView(year, month);
		
		model.addAttribute("month",month);
		model.addAttribute("year", year);
		model.addAttribute("calendar",calendar);
		return "calendar/calendar";
	}
	
	@GetMapping("/plan")
	public String plan(Model model) {
		
		return "calendar/plan";
	}
	@PostMapping("/plan")
	public String insertPlan(Model model, Plan plan, @AuthenticationPrincipal SecurityUser principal, String strPlanDate) throws ParseException {
		System.out.println(plan);
		plan.setUser(principal.getUser());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
		Date date = formatter.parse(strPlanDate);
		plan.setPlanDate(date);
		calendarservice.insertPlan(plan);
		return "calendar/plan";
	}
	
	
}

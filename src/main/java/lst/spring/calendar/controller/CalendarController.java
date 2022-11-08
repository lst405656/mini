package lst.spring.calendar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
		System.out.println(month);
		System.out.println(year);
		
		calendar = calendarservice.calendarView(year, month);
		
		model.addAttribute("month",month);
		model.addAttribute("year", year);
		model.addAttribute("calendar",calendar);
		return "calendar/calendar";
	}
}

package lst.spring.system.calendar;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import lst.spring.Entity.Plan;

public interface CalendarService {
	public List<List<Integer>> calendarView(int year, int month);
	public void insertPlan(Plan plan);
	Page<Plan> getPlanList(Plan plan, int page, Date date);
}

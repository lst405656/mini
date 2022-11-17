package lst.spring.system.calendar;

import java.util.List;

import lst.spring.Entity.Plan;

public interface CalendarService {
	public List<List<Integer>> calendarView(int year, int month);
	public void insertPlan(Plan plan);
}

package lst.spring.system.calendar;

import java.util.List;

public interface CalendarService {
	public List<List<Integer>> calendarView(int year, int month);
}

package lst.spring.system.calendar;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CalendarServiceImpl implements CalendarService {

	LocalDate now = LocalDate.now();
	int year = now.getYear();
	int month = now.getMonth().getValue();
	int day = now.getDayOfMonth();
	
	public boolean isLeapYear(int year) {
		return (year % 4 ==0) && (year % 100 !=0) ||(year % 400 ==0);
	}

	public int lastDay(int year, int month) {
		int[] m = {31,28,31,30,31,30,31,31,30,31,30,31};
		m[1]=isLeapYear(year)? 29:28;
		return m[month-1];
	}

	public int totalDay(int year, int month, int day) {
		int sum = (year-1)*365 +(year-1)/4 - (year-1)/100 +(year-1)/400;
		for (int i = 1; i < month; i++) {
			sum += lastDay(year,i);
		}
		return sum + day;
	}
	
	@Override
	public List<List<Integer>> calendarView() {
		List<Integer> week = new ArrayList<Integer>();
		List<List<Integer>> calendar = new ArrayList<List<Integer>>();
		LocalDate firstDay = now.withDayOfMonth(1);
		int last = lastDay(year,month);
		int first = firstDay.getDayOfWeek().getValue();
		
		if(first==7) {
			first = 0;
		}
		//빈자리 0채우기
		for(int x =0; x<first; x++) {
			week.add(0);
		}
		//남은자리부터 날짜 채우기
		for(int y=1; y<=7-first; y++) {
			week.add(y);
		}
		List<Integer> temp = new ArrayList<Integer>(week);
		calendar.add(temp);
		week.clear();
		
		for(int i=(7-first+1), j=1; i<=last; i++,j++) {
			week.add(i);
			if(j%7==0) {
				temp = new ArrayList<Integer>(week);
				calendar.add(temp);
				week.clear();
			}
		}
		
		
		return calendar;
	}

	
	
	
	
}

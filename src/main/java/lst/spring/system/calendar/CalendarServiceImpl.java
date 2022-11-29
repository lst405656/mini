package lst.spring.system.calendar;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lst.spring.Entity.Plan;
import lst.spring.Repository.CalendarRepository;

@Service
public class CalendarServiceImpl implements CalendarService {

	@Autowired
	CalendarRepository cal;
	
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
	public List<List<Integer>> calendarView(int year, int month) {
		List<Integer> week = new ArrayList<Integer>();
		List<List<Integer>> calendar = new ArrayList<List<Integer>>();
		LocalDate dates = LocalDate.of(year, month, 1);
		LocalDate firstDay = dates.withDayOfMonth(1);
		
		int last = lastDay(year,month);
		int first = firstDay.getDayOfWeek().getValue();//첫번재 날 요일
		if(month==1) {
			month = 12;
			year -= 1;
		}
		int prelast= lastDay(year,month-1);//이전달 마지막날
		
		
		if(first==7) {
			first = 0;
		}
		//빈자리 0채우기
		for(int x =0, k=prelast-first+1; x<first; x++, k++) {
			week.add(k);
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
			if(i==last) {
				temp = new ArrayList<Integer>(week);
				for(int n =1 ; n <= (7-j%7);n++) {
					temp.add(n);
				}
				calendar.add(temp);
				week.clear();
			}
		}
		
		
		
		
		return calendar;
	}

	@Override
	public void insertPlan(Plan plan) {
		cal.save(plan);
	}

	@Override
	public Page<Plan> getPlanList(Plan plan, int page, Date date) {
		Pageable pageable = PageRequest.of(page, 10, Sort.Direction.DESC, "seq");
		return cal.findbyPlanDate(pageable, date);
	}

	@Override
	public Page<Plan> getPlanList(Plan plan, int page, Date date, String familyCode) {
		Pageable pageable = PageRequest.of(page, 10, Sort.Direction.DESC, "seq");
		return cal.findbyPlanDate(pageable, date,familyCode);
	}

	
	
	
	
	
}

package lst.spring.system.calendar;

public class CalendarServiceImpl implements CalendarService {

	@Override
	public boolean isLeapYear(int year) {
		return (year % 4 ==0) && (year % 100 !=0) ||(year % 400 ==0);
	}

	@Override
	public int lastDay(int year, int month) {
		int[] m = {31,28,31,30,31,30,31,31,30,31,30,31};
		m[1]=isLeapYear(year)? 29:28;
		return m[month-1];
	}

	@Override
	public int totalDay(int year, int month, int day) {
		int sum = (year-1)*365 +(year-1)/4 - (year-1)/100 +(year-1)/400;
		for (int i = 1; i < month; i++) {
			sum += lastDay(year,i);
		}
		return sum + day;
	}

	@Override
	public int weekDay(int year, int month, int day) {
		return totalDay(year, month, day) % 7;
	}
}

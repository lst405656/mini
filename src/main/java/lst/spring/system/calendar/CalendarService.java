package lst.spring.system.calendar;

public interface CalendarService {
	public boolean isLeapYear(int year); //년도를 넘겨받아 윤년/ 평년을 판단해 윤년이면 true, 평년이면 false를 리턴하는 메서드
	public int lastDay(int year, int month); //년, 월을 넘겨받아 그 달의 마지막 날짜를 리턴하는 메서드
	public int totalDay(int year, int month, int day); //년, 월, 일을 념겨받아 1년 1월 1일부터 지나온 날짜의 합계를 리턴하는 메서드
	public int weekDay(int year, int month, int day); //년, 월, 일을 넘겨받아 요일을 숫자로 리턴하는 메서드, 일요일(0),월요일(1)....토요일(6)
}

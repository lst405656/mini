package lst.spring;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lst.spring.Entity.Plan;
import lst.spring.Entity.Role;
import lst.spring.Entity.User;
import lst.spring.Repository.CalendarRepository;
import lst.spring.Repository.UserRepository;

@SpringBootTest
public class CalendarRepositoryTest {
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private CalendarRepository calRepo;
	
	@Test
	public void insertPlan() throws ParseException {
		
		User user1 = new User();
		user1.setId("user");
		user1.setPassword("1111");
		user1.setNickname("손오공");
		user1.setEmail("lst4056@naver.com");
		user1.setPhone("010-0100-0011");
		user1.setRole(Role.USER);
		user1.setEnabled(true);
		userRepo.save(user1);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String str = "2022-11-15";
        Date date = format.parse(str);
		
		for(int i=1; i<=10; i++) {
			Plan plan = new Plan();
			plan.setUser(user1);
			plan.setTitle(i + " hi");
			plan.setPlanDate(date);
			plan.setPlanTime("10:00");
			calRepo.save(plan);
		}

	}
}

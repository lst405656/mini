package lst.spring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import lst.spring.Entity.User;
import lst.spring.Entity.UserFormat;
import lst.spring.system.service.UserService;

@SpringBootTest
@Transactional
public class UserRepositoryTest {
	@Autowired
	UserService userService;
	
	@Autowired
	PasswordEncoder passwordencorder;
	
	public User createUser() {
        UserFormat userFormat = UserFormat.builder()
        		.id("lst4056")
                .email("test@email.com")
                .nickname("테스트")
                .password("1111")
                .build();
        return User.createUser(userFormat, passwordencorder);
    }

    @Test
    @DisplayName("회원가입 테스트")
    public void saveUserTest() {
        User user = createUser();
        User savedUser = userService.saveUser(user);

        assertEquals(user.getEmail(), savedUser.getId());
    }
}

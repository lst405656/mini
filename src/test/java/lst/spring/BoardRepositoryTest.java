package lst.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lst.spring.Entity.Board;
import lst.spring.Entity.Role;
import lst.spring.Entity.User;
import lst.spring.Repository.BoardRepository;
import lst.spring.Repository.UserRepository;

@SpringBootTest
public class BoardRepositoryTest {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private BoardRepository boardRepo;
	@Test
	public void testInsert() {
		User user1 = new User();
		user1.setId("user");
		user1.setPassword("1111");
		user1.setNickname("손오공");
		user1.setEmail("lst4056@naver.com");
		user1.setPhone("010-0100-0011");
		user1.setRole(Role.ROLE_USER);
		user1.setEnabled(true);
		userRepo.save(user1);
		User user2 = new User();
		user2.setId("admin");
		user2.setPassword("2222");
		user2.setNickname("사오정");
		user2.setEmail("lst4056@gmail.com");
		user2.setPhone("010-0100-1111");
		user2.setRole(Role.ROLE_ADMIN);
		user2.setEnabled(true);
		userRepo.save(user2);
		
		for(int i=1; i<=13; i++) {
			Board board = new Board();
			board.setUser(user1);
			board.setTitle(user1.getNickname() + "이 등록한 게시글 " + i);
			board.setContent(user1.getNickname() + "이 등록한 게시글 " + i);
			boardRepo.save(board);
		}
		for(int i=1; i<=3; i++) {
			Board board = new Board();
			board.setUser(user2);
			board.setTitle(user2.getNickname() + "이 등록한 게시글 " + i);
			board.setContent(user2.getNickname() + "이 등록한 게시글 " + i);
			boardRepo.save(board);
		}
	}
}

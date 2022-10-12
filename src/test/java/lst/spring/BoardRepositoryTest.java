package lst.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

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
	@Autowired
	private PasswordEncoder encoder;

	@Test
	//	public void testInsert() {
	//		User user1 = new User();
	//		user1.setId("user");
	//		user1.setPassword("1111");
	//		user1.setNickname("손오공");
	//		user1.setEmail("lst4056@naver.com");
	//		user1.setPhone("010-0100-0011");
	//		user1.setRole(Role.ROLE_USER);
	//		user1.setEnabled(true);
	//		userRepo.save(user1);
	//		User user2 = new User();
	//		user2.setId("admin");
	//		user2.setPassword("2222");
	//		user2.setNickname("사오정");
	//		user2.setEmail("lst4056@gmail.com");
	//		user2.setPhone("010-0100-1111");
	//		user2.setRole(Role.ROLE_ADMIN);
	//		user2.setEnabled(true);
	//		userRepo.save(user2);
	//		
	//		for(int i=1; i<=13; i++) {
	//			Board board = new Board();
	//			board.setUser(user1);
	//			board.setTitle(user1.getNickname() + "이 등록한 게시글 " + i);
	//			board.setContent(user1.getNickname() + "이 등록한 게시글 " + i);
	//			boardRepo.save(board);
	//		}
	//		for(int i=1; i<=3; i++) {
	//			Board board = new Board();
	//			board.setUser(user2);
	//			board.setTitle(user2.getNickname() + "이 등록한 게시글 " + i);
	//			board.setContent(user2.getNickname() + "이 등록한 게시글 " + i);
	//			boardRepo.save(board);
	//		}
	//	}
	//	public void testGetBoard() {
	//		Board board = boardRepo.findById(1L).get();
	//		System.out.println(" [ " + board.getSeq() + "번 게시글 상세 정보 ]");
	//		System.out.println("제목\t : " + board.getTitle());
	//		System.out.println("작성자\t : " + board.getUser().getNickname());
	//		System.out.println("내용\t : " + board.getContent());
	//		System.out.println("등록일\t : " + board.getRegDate());
	//		System.out.println("조회수\t : " + board.getCnt());
	//	}

	//	public void testGetBoardList() {
	//		User user = userRepo.findById("user").get();
	//		System.out.println(" [ " + user.getNickname() + "이 등록한 게시글 ]");
	//		for(Board board : user.getBoardList()) {
	//		System.out.println("---> " + board.toString());
	//			}
	//		}

	public void testInsert() {
		User user1 = new User();
		user1.setId("user");
		user1.setPassword(encoder.encode("1111"));
		user1.setNickname("손오공");
		user1.setRole(Role.ROLE_USER);
		user1.setEnabled(true);
		userRepo.save(user1);
		User user2 = new User();
		user2.setId("admin");
		user2.setPassword(encoder.encode("2222"));
		user2.setNickname("사오정");
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

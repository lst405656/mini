package lst.spring.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lst.spring.Entity.User;
import lst.spring.Repository.UserRepository;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public void saveUser(User user) {
		User u = new User();
		u = user;
		u.setPassword(encoder.encode(user.getPassword()));
		
		userRepo.save(u);
	}

}

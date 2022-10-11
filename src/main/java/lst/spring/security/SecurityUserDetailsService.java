package lst.spring.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lst.spring.Entity.User;
import lst.spring.Repository.UserRepository;

@Service
public class SecurityUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		Optional<User> optional= userRepo.findById(username);
		if(!optional.isPresent()) {
			throw new UsernameNotFoundException(username + " 사용자 없음");
		}else {
			User user = optional.get();
			return new SecurityUser(user);
		}
	}
}

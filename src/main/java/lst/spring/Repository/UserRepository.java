package lst.spring.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import lst.spring.Entity.User;

public interface UserRepository extends JpaRepository<User, String>{
	Optional<User> findByEmail(String email);

}

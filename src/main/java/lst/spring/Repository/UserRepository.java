package lst.spring.Repository;

import org.springframework.data.repository.CrudRepository;

import lst.spring.Entity.User;

public interface UserRepository extends CrudRepository<User, String>{

}

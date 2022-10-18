package lst.spring.system.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lst.spring.Entity.User;
import lst.spring.Repository.UserRepository;

@RequiredArgsConstructor
@Transactional
@Service
public class UserService {

    private final UserRepository userRepository;

    public User saveUser(User user) {
        validateDuplicateMember(user);

        return userRepository.save(user);
    }

    private void validateDuplicateMember(User user) {
        Optional<User> findUser = userRepository.findById(user.getId());
        if (findUser != null) {
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }
}
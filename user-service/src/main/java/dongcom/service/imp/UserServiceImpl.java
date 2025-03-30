package dongcom.service.imp;

import dongcom.exception.UserException;
import dongcom.modal.User;
import dongcom.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import dongcom.service.UserService;
import dongcom.exception.UserException;

@Service
public class UserServiceImpl implements UserService {

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> otp = userRepository.findById(id);
        if (otp.isPresent()) {
            return otp.get();
        }
        throw new UserException("user not found with id " + id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        Optional<User> otp = userRepository.findById(id);
        if (otp.isEmpty()) {
            throw new UserException("user not found with id " + id);
        }

        userRepository.deleteById(otp.get().getId());
        // return "User is deleted";
    }

    @Override
    public User updateUser(Long id, User user) {
        Optional<User> otp = userRepository.findById(id);
        if (otp.isEmpty())
            throw new UserException("user not found with id " + id);

        User existingUser = otp.get();
        existingUser.setFullName(user.getFullName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPhone(user.getPhone());
        existingUser.setRole(user.getRole());

        return userRepository.save(existingUser);
    }
}

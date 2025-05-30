package lk.ijse.lost_found_backend.service;


import lk.ijse.lost_found_backend.dao.UserRepository;
import lk.ijse.lost_found_backend.dto.SignupRequest;
import lk.ijse.lost_found_backend.entity.Role;
import lk.ijse.lost_found_backend.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(SignupRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email is already in use");
        }

        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setStudentId(request.getStudentId());
        user.setDepartment(request.getDepartment());
        user.setPhone(request.getPhone());
        user.setAddress(request.getAddress());

        // Default role to USER if null
        user.setRole(request.getRole() != null ? request.getRole() : Role.USER);

        userRepository.save(user);
    }
}

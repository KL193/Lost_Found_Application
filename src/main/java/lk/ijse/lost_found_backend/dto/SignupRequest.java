package lk.ijse.lost_found_backend.dto;

import lk.ijse.lost_found_backend.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String studentId;
    private String department;
    private String phone;
    private String address;
    private Role role;
}

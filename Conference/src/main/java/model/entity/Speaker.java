package model.entity;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class Speaker extends User {
    private long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private User.Role role = User.Role.SPEAKER;
    private int reating;
}
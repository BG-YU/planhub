package kr.co.planhub.domain.users;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Users {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 20, nullable = false)
    private String role;

    @Builder
    public Users(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static Users create(String email, String password) {
        return Users.builder()
                .email(email)
                .password(password)
                .build();
    }

}

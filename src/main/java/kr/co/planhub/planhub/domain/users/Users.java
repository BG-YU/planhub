package kr.co.planhub.planhub.domain.users;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Users {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 15, nullable = false)
    private String password;

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

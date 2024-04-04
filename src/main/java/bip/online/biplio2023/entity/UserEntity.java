package bip.online.biplio2023.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String lastname;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private String password;
    @NotNull
    private String login;

}

package bip.online.biplio2023.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "cities")
public class CityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Pattern(regexp="[А-Я][а-я]{1,20}")
    private String title;

    @JsonIgnore
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<PublisherEntity> publisher;
}

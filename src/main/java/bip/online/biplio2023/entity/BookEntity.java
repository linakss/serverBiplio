package bip.online.biplio2023.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank()
    @Pattern(regexp = "[А-Я][а-я]{1,55}")
    private String title;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorEntity author;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private PublisherEntity publisher;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private GenreEntity genre;
    private String year;
}

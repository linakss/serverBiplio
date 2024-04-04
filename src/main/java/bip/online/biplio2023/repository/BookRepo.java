package bip.online.biplio2023.repository;
import bip.online.biplio2023.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<BookEntity, Long>{
    List<BookEntity> findByTitle(String title);
}
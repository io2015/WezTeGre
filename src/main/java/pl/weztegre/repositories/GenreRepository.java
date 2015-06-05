package pl.weztegre.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.weztegre.models.Genre;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
    Genre findByGenre(String genre);
    List<Genre> findByIdIn(List<Integer> ids);
}

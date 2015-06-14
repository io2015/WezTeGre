package pl.weztegre.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.weztegre.models.Advertisement;

import java.util.List;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Integer> {
    @Query("SELECT a FROM Advertisement a WHERE a.title LIKE %?1% OR a.content LIKE %?1% OR a.game.name LIKE %?1%")
    List<Advertisement> findByTitleOrContentOrGame(String filter);

    @Query("SELECT a FROM Advertisement a WHERE a.title LIKE %?1%")
    List<Advertisement> findByTitle(String filter);

    @Query("SELECT a FROM Advertisement a WHERE a.title LIKE %?1% OR a.content LIKE %?1%")
    List<Advertisement> findByTitleOrContent(String filter);

    @Query("SELECT a FROM Advertisement a WHERE a.title LIKE %?1% OR a.game.name LIKE %?1%")
    List<Advertisement> findByTitleOrGame(String filter);
}

package pl.weztegre.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.weztegre.models.Distribution;
import pl.weztegre.models.Game;

public interface GameRepository extends JpaRepository<Game, Integer> {
    Game findByName(String name);
}

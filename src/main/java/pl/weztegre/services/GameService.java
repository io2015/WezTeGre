package pl.weztegre.services;

import pl.weztegre.models.Distribution;
import pl.weztegre.models.Game;
import pl.weztegre.models.Genre;

import java.util.List;

public interface GameService {
        List<Game> findAll();
        Game findByName(String name);
        Game findOne(Integer id);
        void createGame(String name, Genre genre);
}

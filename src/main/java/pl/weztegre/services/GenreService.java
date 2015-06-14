package pl.weztegre.services;

import pl.weztegre.models.Genre;

import java.util.List;

public interface GenreService {
    Genre findByGenre(String genre);
    void createGenre(String genre);
    List<Genre> findAll();
    List<Genre> findByIdIn(List<Integer> ids);
}

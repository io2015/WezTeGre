package pl.weztegre.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.weztegre.models.Genre;
import pl.weztegre.repositories.GenreRepository;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    @Autowired
    private GenreRepository genreRepository;

    @Override
    public Genre findByGenre(String genre) {
        return genreRepository.findByGenre(genre);
    }

    public void createGenre(String genre) {
        genreRepository.save(new Genre(genre));
    }

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    public List<Genre> findByIdIn(List<Integer> ids) {
        return genreRepository.findByIdIn(ids);
    }
}

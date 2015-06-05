package pl.weztegre.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.weztegre.models.*;
import pl.weztegre.repositories.GameRepository;

import java.util.LinkedList;
import java.util.List;


@Service
@Transactional
public class GameServiceImpl implements GameService {
    private final Logger LOGGER = LoggerFactory.getLogger(GameServiceImpl.class);

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private DistributionService distributionService;

    @Autowired
    private LanguageService languageService;

    @Autowired
    private PlatformService platformService;

    @Override
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    @Override
    public Game findByName(String name) {
        return gameRepository.findByName(name);
    }

    @Override
    public Game findOne(Integer id) {
        return gameRepository.findOne(id);
    }

    @Override
    public void createGame(String name, Genre genre) {
        Game game = new Game(name, genre);

        gameRepository.save(game);
    }
}

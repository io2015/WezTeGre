package pl.weztegre.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.weztegre.models.Genre;
import pl.weztegre.repositories.GenreRepository;
import pl.weztegre.services.*;

@Component
public class ContextRefreshedListener implements ApplicationListener<ContextRefreshedEvent> {
    private final Logger LOGGER = LoggerFactory.getLogger(ContextRefreshedListener.class);

    private boolean configured = false;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PlatformService platformService;

    @Autowired
    private LanguageService languageService;

    @Autowired
    private DistributionService distributionService;

    @Autowired
    private GameService gameService;

    @Autowired
    private GenreService genreService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if(roleService == null || configured == true)
            return;

        LOGGER.info("Wstepne konfigurowanie bazy danych. Dodawanie rol.");
        createRoleIfDoesntExist("ROLE_USER");
        createRoleIfDoesntExist("ROLE_ADMIN");

        LOGGER.info("Dodawanie platform.");
        createPlatformIfDoesntExist("Xbox 360");
        createPlatformIfDoesntExist("PlayStation 3");
        createPlatformIfDoesntExist("Microsoft Windows");
        createPlatformIfDoesntExist("OS X");
        createPlatformIfDoesntExist("Linux");
        createPlatformIfDoesntExist("iOS");
        createPlatformIfDoesntExist("Android");
        createPlatformIfDoesntExist("Xbox One");

        LOGGER.info("Dodawanie języków.");
        createLanguageIfDoesntExist("Polski");
        createLanguageIfDoesntExist("Angielski");
        createLanguageIfDoesntExist("Ciapacki");
        createLanguageIfDoesntExist("Niemiecki");

        LOGGER.info("Dodawanie nośników.");
        createDistributionIfDoesntExist("Steam");
        createDistributionIfDoesntExist("Płyta CD");
        createDistributionIfDoesntExist("Płyta DVD");

        LOGGER.info("Dodawanie gatunków");
        createGenreIfDoesntExist("first-person shooter");
        createGenreIfDoesntExist("gra akcji");
        createGenreIfDoesntExist("wyścigi");


        LOGGER.info("Dodawanie przykładowych gier.");
        createGameIfDoesntExist("Far Cry 3", genreService.findByGenre("first-person shooter"));
        createGameIfDoesntExist("Need For Speed: Most Wanted", genreService.findByGenre("wyścigi"));
        createGameIfDoesntExist("Grand Theft Auto V", genreService.findByGenre("gra akcji"));

        configured = true;
    }

    private void createRoleIfDoesntExist(String role) {
        if(roleService.findRole(role) == null) {
            LOGGER.info("Nie znaleziono roli " + role + ". Dodawanie...");
            roleService.createRole(role);
        }
        else
            LOGGER.info("Rola " + role + " juz istnieje.");
    }

    private void createPlatformIfDoesntExist(String platform) {
        if(platformService.findByPlatform(platform) == null) {
            LOGGER.info("Nie znaleziono platformy " + platform + ". Dodawanie...");
            platformService.createPlatform(platform);
        }
        else
            LOGGER.info("Platforma " + platform + " juz istnieje.");
    }

    private void createLanguageIfDoesntExist(String language) {
        if(languageService.findByLanguage(language) == null) {
            LOGGER.info("Nie znaleziono języka " + language + ". Dodawanie...");
            languageService.createLanguage(language);
        }
        else
            LOGGER.info("Język " + language + " juz istnieje.");
    }

    private void createDistributionIfDoesntExist(String distribution) {
        if(distributionService.findByDistribution(distribution) == null) {
            LOGGER.info("Nie znaleziono nośnika " + distribution + ". Dodawanie...");
            distributionService.createDistribution(distribution);
        }
        else
            LOGGER.info("Nośnik " + distribution + " juz istnieje.");
    }

    private void createGameIfDoesntExist(String name, Genre genre) {
        if(gameService.findByName(name) == null) {
            LOGGER.info("Nie znaleziono gry " + name + ". Dodawanie...");
            gameService.createGame(name, genre);
        }
        else
            LOGGER.info("Gra " + name + " juz istnieje.");
    }

    private void createGenreIfDoesntExist(String genre) {
        if(genreService.findByGenre(genre) == null) {
            LOGGER.info("Nie znaleziono gatunku " + genre + ". Dodawanie...");
            genreService.createGenre(genre);
        }
        else
            LOGGER.info("Gatunek " + genre + " juz istnieje.");
    }
}

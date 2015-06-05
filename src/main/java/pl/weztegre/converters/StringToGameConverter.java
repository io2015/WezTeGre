package pl.weztegre.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.weztegre.models.Game;
import pl.weztegre.services.GameService;

public class StringToGameConverter implements Converter<String, Game> {
    @Autowired
    private GameService gameService;

    @Override
    public Game convert(String s) {
        int delimiter = s.indexOf('|');
        return gameService.findByName(s.substring(0, delimiter-1));
    }
}

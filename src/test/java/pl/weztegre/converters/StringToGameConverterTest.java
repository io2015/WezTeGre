package pl.weztegre.converters;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import pl.weztegre.models.Game;
import pl.weztegre.services.GameService;

import static org.junit.Assert.*;

/**
 * Created by st3rn on 13.06.15.
 */
@RunWith(MockitoJUnitRunner.class)
public class StringToGameConverterTest {
    @InjectMocks StringToGameConverter stringToGameConverter;
    @Mock private GameService gameServiceMock;
    @Mock private Game gameMock;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testConvert() throws Exception {
        Mockito.when(gameServiceMock.findByName("asdf")).thenReturn(gameMock);
        assertEquals(gameMock,stringToGameConverter.convert("asdf |"));
    }
}
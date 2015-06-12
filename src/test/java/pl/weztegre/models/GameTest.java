package pl.weztegre.models;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import pl.weztegre.EqualsTester;

import static org.junit.Assert.*;

/**
 * Created by st3rn on 15.05.15.
 */
@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    private Game Game;
    private Game Game2;

    @Before
    public void setUp() throws Exception {
        Game = new Game();
        Game.setId(1);
        Game2 = new Game();
        Game2.setId(2);

    }

    @Test
    public void testToString() throws Exception {
        assertEquals("null | null",
                Game.toString());

    }

}
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
    public void testEquals() throws Exception {
        EqualsTester<Game> equalsTester = EqualsTester.newInstance(new Game());
        equalsTester.assertEqual(new Game(), new Game());
        equalsTester.assertNotEqual(Game, Game2);
    }

    @Test
    public void testHashCode() throws Exception {
        Game2.setId(1);
        assertTrue(Game.equals(Game2) && Game2.equals(Game));
        assertTrue(Game.hashCode() == Game2.hashCode());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("Game{id=1, name='null', platforms=[], distributions=[], languages=[], genres=[]}",
                Game.toString());

    }

}
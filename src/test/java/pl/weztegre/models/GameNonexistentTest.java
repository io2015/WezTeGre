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
public class GameNonexistentTest {

    private GameNonexistent GameNonexistent;
    private GameNonexistent GameNonexistent2;

    @Before
    public void setUp() throws Exception {
        GameNonexistent = new GameNonexistent();
        GameNonexistent.setId(1);
        GameNonexistent2 = new GameNonexistent();
        GameNonexistent2.setId(2);

    }

    @Test
    public void testEquals() throws Exception {
        EqualsTester<GameNonexistent> equalsTester = EqualsTester.newInstance(new GameNonexistent());
        equalsTester.assertEqual(new GameNonexistent(), new GameNonexistent());
        equalsTester.assertNotEqual(GameNonexistent, GameNonexistent2);
    }

    @Test
    public void testHashCode() throws Exception {
        GameNonexistent2.setId(1);
        assertTrue(GameNonexistent.equals(GameNonexistent2) && GameNonexistent2.equals(GameNonexistent));
        assertTrue(GameNonexistent.hashCode() == GameNonexistent2.hashCode());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("GameNonexistent{id=1, name='null', description='null'}",
                GameNonexistent.toString());

    }

}
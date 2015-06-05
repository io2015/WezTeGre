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
public class GenreTest {

    private Genre Genre;
    private Genre Genre2;

    @Before
    public void setUp() throws Exception {
        Genre = new Genre();
        Genre.setId(1);
        Genre2 = new Genre();
        Genre2.setId(2);

    }

    @Test
    public void testEquals() throws Exception {
        EqualsTester<Genre> equalsTester = EqualsTester.newInstance(new Genre());
        equalsTester.assertEqual(new Genre(), new Genre());
        equalsTester.assertNotEqual(Genre, Genre2);
    }

    @Test
    public void testHashCode() throws Exception {
        Genre2.setId(1);
        assertTrue(Genre.equals(Genre2) && Genre2.equals(Genre));
        assertTrue(Genre.hashCode() == Genre2.hashCode());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("Genre{id=1, genre='null'}",
                Genre.toString());

    }

}
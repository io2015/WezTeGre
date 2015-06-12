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
public class LanguageTest {

    private Language Language;
    private Language Language2;

    @Before
    public void setUp() throws Exception {
        Language = new Language();
        Language.setId(1);
        Language2 = new Language();
        Language2.setId(2);

    }

    @Test
    public void testEquals() throws Exception {
        EqualsTester<Language> equalsTester = EqualsTester.newInstance(new Language());
        equalsTester.assertEqual(new Language(), new Language());
        equalsTester.assertNotEqual(Language, Language2);
    }

    @Test
    public void testHashCode() throws Exception {
        Language2.setId(1);
        assertTrue(Language.equals(Language2) && Language2.equals(Language));
        assertTrue(Language.hashCode() == Language2.hashCode());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals(null,
                Language.toString());

    }

}
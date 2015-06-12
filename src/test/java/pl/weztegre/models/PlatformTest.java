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
public class PlatformTest {

    private Platform Platform;
    private Platform Platform2;

    @Before
    public void setUp() throws Exception {
        Platform = new Platform();
        Platform.setId(1);
        Platform2 = new Platform();
        Platform2.setId(2);

    }

    @Test
    public void testEquals() throws Exception {
        EqualsTester<Platform> equalsTester = EqualsTester.newInstance(new Platform());
        equalsTester.assertEqual(new Platform(), new Platform());
        equalsTester.assertNotEqual(Platform, Platform2);
    }

    @Test
    public void testHashCode() throws Exception {
        Platform2.setId(1);
        assertTrue(Platform.equals(Platform2) && Platform2.equals(Platform));
        assertTrue(Platform.hashCode() == Platform2.hashCode());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals(null,
                Platform.toString());

    }

}
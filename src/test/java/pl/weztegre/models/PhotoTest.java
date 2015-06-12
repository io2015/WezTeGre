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
public class PhotoTest {

    private Photo Photo;
    private Photo Photo2;

    @Before
    public void setUp() throws Exception {
        Photo = new Photo();
        Photo.setId(1);
        Photo2 = new Photo();
        Photo2.setId(2);

    }

    @Test
    public void testEquals() throws Exception {
        EqualsTester<Photo> equalsTester = EqualsTester.newInstance(new Photo());
        equalsTester.assertEqual(new Photo(), new Photo());
        equalsTester.assertNotEqual(Photo, Photo2);
    }

    @Test
    public void testHashCode() throws Exception {
        Photo2.setId(1);
        assertTrue(Photo.equals(Photo2) && Photo2.equals(Photo));
        assertTrue(Photo.hashCode() == Photo2.hashCode());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("Photo{id=1, exchange=null, advertisement=null, url='null'}",
                Photo.toString());

    }

}
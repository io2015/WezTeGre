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
public class PictureTest {

    private Picture Picture;
    private Picture Picture2;

    @Before
    public void setUp() throws Exception {
        Picture = new Picture();
        Picture.setId(1);
        Picture2 = new Picture();
        Picture2.setId(2);

    }

    @Test
    public void testEquals() throws Exception {
        EqualsTester<Picture> equalsTester = EqualsTester.newInstance(new Picture());
        equalsTester.assertEqual(new Picture(), new Picture());
        equalsTester.assertNotEqual(Picture, Picture2);
    }

    @Test
    public void testHashCode() throws Exception {
        Picture2.setId(1);
        assertTrue(Picture.equals(Picture2) && Picture2.equals(Picture));
        assertTrue(Picture.hashCode() == Picture2.hashCode());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("Picture{id=1, exchange=null, advertisement=null, url='null'}",
                Picture.toString());

    }

}
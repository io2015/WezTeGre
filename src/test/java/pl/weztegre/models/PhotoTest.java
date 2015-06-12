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
    public void test() {}

}
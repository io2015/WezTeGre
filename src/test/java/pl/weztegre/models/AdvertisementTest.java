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
public class AdvertisementTest {

    private Advertisement advertisement;
    private Advertisement advertisement2;

    @Before
    public void setUp() throws Exception {
        advertisement = new Advertisement();
        advertisement.setId(1);
        advertisement2 = new Advertisement();
        advertisement2.setId(2);

    }

    @Test
    public void test() {}
}
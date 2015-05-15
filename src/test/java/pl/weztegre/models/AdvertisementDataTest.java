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
public class AdvertisementDataTest {

    private AdvertisementData advertisementData;
    private AdvertisementData advertisementData2;


    @Before
    public void setUp() throws Exception {
        advertisementData = new AdvertisementData();
        advertisementData.setId(1);
        advertisementData2 = new AdvertisementData();
        advertisementData2.setId(2);
    }

    @Test
    public void testEquals() throws Exception {
        EqualsTester<AdvertisementData> equalsTester = EqualsTester.newInstance(new AdvertisementData());
        equalsTester.assertEqual(new AdvertisementData(), new AdvertisementData());
        equalsTester.assertNotEqual(advertisementData, advertisementData2);
    }

    @Test
    public void testHashCode() throws Exception {
        advertisementData2.setId(1);
        assertTrue(advertisementData.equals(advertisementData2) && advertisementData2.equals(advertisementData));
        assertTrue(advertisementData.hashCode() == advertisementData2.hashCode());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("AdvertisementData{id=1, advertisement=null, gameNonexistent=null, game=null, category=null}",
                advertisementData.toString());
    }
}
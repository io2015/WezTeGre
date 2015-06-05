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
public class AdvertisementArchiveTest {

    private AdvertisementArchive advertisementArchive;
    private AdvertisementArchive advertisementArchive2;

    @Before
    public void setUp() throws Exception {
        advertisementArchive = new AdvertisementArchive();
        advertisementArchive.setExchanged(true);
        advertisementArchive2 = new AdvertisementArchive();
        advertisementArchive2.setExchanged(false);

    }

    @Test
    public void testEquals() throws Exception {
        EqualsTester<AdvertisementArchive> equalsTester = EqualsTester.newInstance(new AdvertisementArchive());
        equalsTester.assertEqual(new AdvertisementArchive(), new AdvertisementArchive());
        equalsTester.assertNotEqual(advertisementArchive, advertisementArchive2);

    }

    @Test
    public void testHashCode() throws Exception {
        advertisementArchive2.setExchanged(true);
        assertTrue(advertisementArchive.equals(advertisementArchive2) && advertisementArchive2.equals(advertisementArchive));
        assertTrue(advertisementArchive.hashCode() == advertisementArchive2.hashCode());

    }

    @Test
    public void testToString() throws Exception {
        assertEquals("AdvertisementArchive{endTime=null, exchanged=true} Advertisement{id=null, title='null', content='null', state=null, addTime=null, potencialEndTime=null, nonexistentGame=null, platforms=[], languages=[], distribution=[]}",
                advertisementArchive.toString());

    }
}
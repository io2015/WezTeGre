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
public class ExchangeArchiveTest {
    private ExchangeArchive ExchangeArchive;
    private ExchangeArchive ExchangeArchive2;

    @Before
    public void setUp() throws Exception {
        ExchangeArchive = new ExchangeArchive();
        ExchangeArchive.setId(1);
        ExchangeArchive2 = new ExchangeArchive();
        ExchangeArchive2.setId(2);

    }

    @Test
    public void testEquals() throws Exception {
        EqualsTester<ExchangeArchive> equalsTester = EqualsTester.newInstance(new ExchangeArchive());
        equalsTester.assertEqual(new ExchangeArchive(), new ExchangeArchive());
        equalsTester.assertNotEqual(ExchangeArchive, ExchangeArchive2);
    }

    @Test
    public void testHashCode() throws Exception {
        ExchangeArchive2.setId(1);
        assertTrue(ExchangeArchive.equals(ExchangeArchive2) && ExchangeArchive2.equals(ExchangeArchive));
        assertTrue(ExchangeArchive.hashCode() == ExchangeArchive2.hashCode());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("ExchangeArchive{endTime=null, accepted=false} Exchange{id=1, user=null, advertisement=null, game=null, data=null, comment='null'}",
                ExchangeArchive.toString());

    }

}
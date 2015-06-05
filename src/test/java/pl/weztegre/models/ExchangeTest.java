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
public class ExchangeTest {
    private Exchange Exchange;
    private Exchange Exchange2;

    @Before
    public void setUp() throws Exception {
        Exchange = new Exchange();
        Exchange.setId(1);
        Exchange2 = new Exchange();
        Exchange2.setId(2);

    }

    @Test
    public void testEquals() throws Exception {
        EqualsTester<Exchange> equalsTester = EqualsTester.newInstance(new Exchange());
        equalsTester.assertEqual(new Exchange(), new Exchange());
        equalsTester.assertNotEqual(Exchange, Exchange2);
    }

    @Test
    public void testHashCode() throws Exception {
        Exchange2.setId(1);
        assertTrue(Exchange.equals(Exchange2) && Exchange2.equals(Exchange));
        assertTrue(Exchange.hashCode() == Exchange2.hashCode());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("Exchange{id=1, user=null, advertisement=null, game=null, data=null, comment='null'}",
                Exchange.toString());

    }

}
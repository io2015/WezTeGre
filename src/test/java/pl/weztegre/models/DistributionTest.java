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
public class DistributionTest {
    private Distribution Distribution;
    private Distribution Distribution2;

    @Before
    public void setUp() throws Exception {
        Distribution = new Distribution();
        Distribution.setId(1);
        Distribution2 = new Distribution();
        Distribution2.setId(2);

    }

    @Test
    public void testEquals() throws Exception {
        EqualsTester<Distribution> equalsTester = EqualsTester.newInstance(new Distribution());
        equalsTester.assertEqual(new Distribution(), new Distribution());
        equalsTester.assertNotEqual(Distribution, Distribution2);
    }

    @Test
    public void testHashCode() throws Exception {
        Distribution2.setId(1);
        assertTrue(Distribution.equals(Distribution2) && Distribution2.equals(Distribution));
        assertTrue(Distribution.hashCode() == Distribution2.hashCode());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("Distribution{id=1, distribution='null'}",
                Distribution.toString());

    }
}
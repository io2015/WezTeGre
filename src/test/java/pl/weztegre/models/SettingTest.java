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
public class SettingTest {

    private Setting Setting;
    private Setting Setting2;

    @Before
    public void setUp() throws Exception {
        Setting = new Setting();
        Setting.setId(1);
        Setting2 = new Setting();
        Setting2.setId(2);

    }

    @Test
    public void testEquals() throws Exception {
        EqualsTester<Setting> equalsTester = EqualsTester.newInstance(new Setting());
        equalsTester.assertEqual(new Setting(), new Setting());
        equalsTester.assertNotEqual(Setting, Setting2);
    }

    @Test
    public void testHashCode() throws Exception {
        Setting2.setId(1);
        assertTrue(Setting.equals(Setting2) && Setting2.equals(Setting));
        assertTrue(Setting.hashCode() == Setting2.hashCode());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("Setting{id=1, value='null'}",
                Setting.toString());

    }
}
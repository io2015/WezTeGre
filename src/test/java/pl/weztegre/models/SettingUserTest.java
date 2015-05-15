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
public class SettingUserTest {

    private SettingUser SettingUser;
    private SettingUser SettingUser2;

    @Before
    public void setUp() throws Exception {
        SettingUser = new SettingUser();
        SettingUser.setIdUser(1);
        SettingUser2 = new SettingUser();
        SettingUser2.setIdUser(2);

    }

    @Test
    public void testEquals() throws Exception {
        EqualsTester<SettingUser> equalsTester = EqualsTester.newInstance(new SettingUser());
        equalsTester.assertEqual(new SettingUser(), new SettingUser());
        equalsTester.assertNotEqual(SettingUser, SettingUser2);
    }

    @Test
    public void testHashCode() throws Exception {
        SettingUser2.setIdUser(1);
        assertTrue(SettingUser.equals(SettingUser2) && SettingUser2.equals(SettingUser));
        assertTrue(SettingUser.hashCode() == SettingUser2.hashCode());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("SettingUser{idUser=1, idSetting=null, user=null, setting=null, value='null'}",
                SettingUser.toString());

    }

}
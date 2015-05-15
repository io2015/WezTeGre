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
public class ResetedPasswordTest {

    private ResetedPassword ResetedPassword;
    private ResetedPassword ResetedPassword2;

    @Before
    public void setUp() throws Exception {
        ResetedPassword = new ResetedPassword();
        ResetedPassword.setId(1);
        ResetedPassword2 = new ResetedPassword();
        ResetedPassword2.setId(2);

    }

    @Test
    public void testEquals() throws Exception {
        EqualsTester<ResetedPassword> equalsTester = EqualsTester.newInstance(new ResetedPassword());
        equalsTester.assertEqual(new ResetedPassword(), new ResetedPassword());
        equalsTester.assertNotEqual(ResetedPassword, ResetedPassword2);
    }

    @Test
    public void testHashCode() throws Exception {
        ResetedPassword2.setId(1);
        assertTrue(ResetedPassword.equals(ResetedPassword2) && ResetedPassword2.equals(ResetedPassword));
        assertTrue(ResetedPassword.hashCode() == ResetedPassword2.hashCode());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("Registration{id=1, user=null, token='null', expiryDate=null}",
                ResetedPassword.toString());

    }

}
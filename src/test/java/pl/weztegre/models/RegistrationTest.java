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
public class RegistrationTest {

    private Registration Registration;
    private Registration Registration2;

    @Before
    public void setUp() throws Exception {
        Registration = new Registration();
        Registration.setId(1);
        Registration2 = new Registration();
        Registration2.setId(2);

    }

    @Test
    public void testEquals() throws Exception {
        EqualsTester<Registration> equalsTester = EqualsTester.newInstance(new Registration());
        equalsTester.assertEqual(new Registration(), new Registration());
        equalsTester.assertNotEqual(Registration, Registration2);
    }

    @Test
    public void testHashCode() throws Exception {
        Registration2.setId(1);
        assertTrue(Registration.equals(Registration2) && Registration2.equals(Registration));
        assertTrue(Registration.hashCode() == Registration2.hashCode());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("Registration{id=1, user=null, token='null', expiryDate=null}",
                Registration.toString());

    }
    
}
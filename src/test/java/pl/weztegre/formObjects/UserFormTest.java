package pl.weztegre.formObjects;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import pl.weztegre.EqualsTester;

import static org.junit.Assert.*;

/**
 * Created by st3rn on 14.05.15.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserFormTest {

    private UserForm userForm;
    private UserForm userForm2;

    @Before
    public void setUp() throws Exception {
        userForm = new UserForm("email", "user", "surname", "password", "passwordConfirmation");
        userForm2 = new UserForm(null, null, null, null, null);
    }

    @Test
    public void testEquals() throws Exception {
        EqualsTester<UserForm> equalsTester = EqualsTester.newInstance(new UserForm());
        equalsTester.assertEqual(new UserForm("email", "user", "surname", "password", "passwordConfirmation"),userForm);
        equalsTester.assertNotEqual(new UserForm(null, "user", "surname", "password", "passwordConfirmation"),userForm);
        //assertTrue(userForm.equals(userForm));
        //assertFalse(userForm.equals(userForm2));
    }

    @Test
    public void testHashCode() throws Exception {
        assertEquals(0, userForm2.hashCode());
        userForm2 = new UserForm("email", "user", "surname", "password", "passwordConfirmation");
        assertTrue(userForm.equals(userForm2) && userForm2.equals(userForm));
        assertTrue(userForm.hashCode() == userForm2.hashCode());
        /*int result = ((((userForm.getEmail().hashCode()*31 + userForm.getName().hashCode())*31 + userForm.getSurname().hashCode())*31 +
            userForm.getPassword().hashCode())*31 + userForm.getPasswordConfirmation().hashCode());
        assertEquals(result, userForm.hashCode());*/
    }
}
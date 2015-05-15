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
public class RoleTest {

    private Role Role;
    private Role Role2;

    @Before
    public void setUp() throws Exception {
        Role = new Role();
        Role.setId(1);
        Role2 = new Role();
        Role2.setId(2);

    }

    @Test
    public void testEquals() throws Exception {
        EqualsTester<Role> equalsTester = EqualsTester.newInstance(new Role());
        equalsTester.assertEqual(new Role(), new Role());
        equalsTester.assertNotEqual(Role, Role2);
    }

    @Test
    public void testHashCode() throws Exception {
        Role2.setId(1);
        assertTrue(Role.equals(Role2) && Role2.equals(Role));
        assertTrue(Role.hashCode() == Role2.hashCode());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("Role{id=1, role='null'}",
                Role.toString());

    }

}
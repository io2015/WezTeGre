package pl.weztegre.models;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import static org.junit.Assert.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.weztegre.EqualsTester;
import pl.weztegre.formObjects.UserForm;
//import pl.weztegre.repositories.UserRepository;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:database_test-context.xml", "classpath:validator_test-context.xml"})
public class UserFormTest {

    private UserForm UserForm;
    private UserForm UserForm2;

    @Before
    public void setUp() throws Exception {
        UserForm = new UserForm();
        UserForm.setName("Bartosz");
        UserForm2 = new UserForm();
        UserForm2.setName("Zdzisław");

    }

    @Test
    public void testEquals() throws Exception {
        EqualsTester<UserForm> equalsTester = EqualsTester.newInstance(new UserForm());
        equalsTester.assertEqual(new UserForm(), new UserForm());
        equalsTester.assertNotEqual(UserForm, UserForm2);
    }

    @Test
    public void testHashCode() throws Exception {
        UserForm2.setName("Bartosz");
        assertTrue(UserForm.equals(UserForm2) && UserForm2.equals(UserForm));
        assertTrue(UserForm.hashCode() == UserForm2.hashCode());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("pl.weztegre.formObjects.UserForm@276bff4b",
                UserForm.toString());

    }
    
   /* @Autowired
    private UserRepository userRepository;

    @Autowired
    private Validator validator;

    @BeforeClass
    public static void setUp() throws Exception {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void fieldsAreNull() {
        UserForm user = new UserForm();


        //assertEquals(5, constraintViolationSet.size());
    }

    @Test
    public void fieldsAreGood() {
        UserForm user = new UserForm("slitbrokacik@buziaczek.info", "Bartosz", "Skotarek", "asdfg", "asdfg");

        User user1 = userRepository.save(new User("slitbrokacik@buziaczek.info", "Bartosz", "Skotarek", ""));
//
//        List<User> asdas = userRepository.findAll();

        Set<ConstraintViolation<UserForm>> constraintViolationSet = validator.validate(user);

        Set<ConstraintViolation<UserForm>> constraintViolationSet1 = validator.validate(new UserForm("slitbrokacik@buziaczek.info", "Bartosz", "Skotarek", "asdfg", "asdfg"));

        assertEquals(5, constraintViolationSet.size());


        //assertEquals(0, constraintViolationSet.size());
    }*/
}
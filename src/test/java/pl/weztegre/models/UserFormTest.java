package pl.weztegre.models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.weztegre.formObjects.UserForm;
import pl.weztegre.repositories.UserRepository;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:database_test-context.xml", "classpath:validator_test-context.xml"})
public class UserFormTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Validator validator;

//    @BeforeClass
//    public static void setUp() throws Exception {
//        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//        validator = factory.getValidator();
//    }

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
    }
}
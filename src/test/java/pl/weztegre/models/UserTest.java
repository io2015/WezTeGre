package pl.weztegre.models;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.junit.Assert.*;

public class UserTest {
    private static Validator validator;

    @BeforeClass
    public static void setUp() throws Exception {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void fieldsAreNull() {
        User user = new User();

        Set<ConstraintViolation<User>> constraintViolationSet = validator.validate(user);

        assertEquals(5, constraintViolationSet.size());
    }

    @Test
    public void fieldsAreGood() {
        User user = new User("Skotar", "Bartosz", "Skotarek", "slitbrokacik@buziaczek.info", "");

        Set<ConstraintViolation<User>> constraintViolationSet = validator.validate(user);

        assertEquals(0, constraintViolationSet.size());
    }
}
package pl.weztegre.models;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.weztegre.formObjects.UserForm;
import pl.weztegre.repositories.UserRepository;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Set;

import static org.junit.Assert.assertEquals;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:database_test-context.xml", "classpath:validator_test-context.xml"})
public class AnnotationTest {

    @Before
    public void fieldsAreNull() {
        UserForm user = new UserForm();

        Class userClass = User.class;


        for(Field field : User.class.getDeclaredFields()){
            Class type = field.getType();
            String name = field.getName();
            Annotation[] annotations = field.getDeclaredAnnotations();

            String asasd = "ASdas";
            asasd = "ASd";
        }
    }

    @Test
    public void asdsa() {

    }


}
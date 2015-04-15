package pl.weztegre.models;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;
import pl.weztegre.repositories.RegistrationRepository;
import pl.weztegre.repositories.UserRepository;
import pl.weztegre.services.RegistrationService;
import pl.weztegre.services.RegistrationServiceImpl;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
@RunWith(MockitoJUnitRunner.class)
public class RegistrationServiceTest {


    //private RegistrationServiceImpl registrationService;

    @Mock
    private UserRepository userRepository;

//    @Mock
//    private UserRepository userRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        //registrationService = new RegistrationServiceImpl();
        //ReflectionTestUtils.setField(registrationService, "registrationRepository", registrationRepository);
    }

    @Test
    public void fieldsAreNull() {
        userRepository.save(new User("asda", "asda", "asda", "asda", "asda"));
        List<User> list = userRepository.findAll();
        String ww = new String();
        ww =  "2312";
    }
}
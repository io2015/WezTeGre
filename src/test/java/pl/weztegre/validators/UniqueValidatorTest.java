package pl.weztegre.validators;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.validation.ConstraintValidatorContext;

import static org.junit.Assert.*;

/**
 * Created by st3rn on 15.05.15.
 */
@RunWith(MockitoJUnitRunner.class)
public class UniqueValidatorTest {

    private UniqueValidator uniqueValidator;
    @Mock private ConstraintValidatorContext constraintValidatorContextMock;

    @Before
    public void setUp() throws Exception {
        ConstraintValidatorContext constraintValidatorContextMock = Mockito.mock(ConstraintValidatorContext.class, Mockito.RETURNS_DEEP_STUBS);     //zajebiste
        uniqueValidator = new UniqueValidator();

    }

    @Test
    public void testIsValid() throws Exception {
        Mockito.when(constraintValidatorContextMock.buildConstraintViolationWithTemplate(null).addPropertyNode(null).addConstraintViolation()).thenReturn(constraintValidatorContextMock);

        assertFalse(uniqueValidator.isValid("", constraintValidatorContextMock));

        Mockito.verify(constraintValidatorContextMock).disableDefaultConstraintViolation();
        Mockito.verify(constraintValidatorContextMock).buildConstraintViolationWithTemplate(null).addPropertyNode(null).addConstraintViolation();

    }
}
package pl.weztegre.validators;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import javax.validation.ConstraintValidatorContext;

import static org.junit.Assert.*;

/**
 * Created by st3rn on 15.05.15.
 */
@RunWith(MockitoJUnitRunner.class)
public class UniqueValidatorTest {

    private UniqueValidator uniqueValidator;
    @Mock private ConstraintValidatorContext constraintValidatorContextMock;
    @Mock private Object objectMock;
    @Mock private BeanUtils beanUtilsMock;
    @Mock private ConstraintValidatorContext.ConstraintViolationBuilder.NodeBuilderCustomizableContext nodeBuilderCustomizableContextMock;
    @Mock private ConstraintValidatorContext.ConstraintViolationBuilder constraintViolationBuilderMock;

    @Before
    public void setUp() throws Exception {
        constraintValidatorContextMock = Mockito.mock(ConstraintValidatorContext.class, Mockito.RETURNS_DEEP_STUBS);     //zajebiste
        uniqueValidator = new UniqueValidator();
    }

    @Test
    public void testIsValid() throws Exception {
        Mockito.when(constraintValidatorContextMock.buildConstraintViolationWithTemplate(null).addConstraintViolation()).thenReturn(constraintValidatorContextMock);

        assertFalse(uniqueValidator.isValid("", constraintValidatorContextMock));

        Mockito.verify(constraintValidatorContextMock).disableDefaultConstraintViolation();
        //cvc.buildConstraintViolationWithTemplate(messageName)/*.addPropertyNode(column)*/.addConstraintViolation();
        //Mockito.verify(constraintValidatorContextMock, Mockito.atLeastOnce()).buildConstraintViolationWithTemplate(null).addConstraintViolation();

    }
}
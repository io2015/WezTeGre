package pl.weztegre.validators;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.validation.Constraint;
import javax.validation.ConstraintValidatorContext;
import javax.validation.metadata.ConstraintDescriptor;

import static org.junit.Assert.*;

/**
 * Created by st3rn on 15.05.15.
 */
@RunWith(MockitoJUnitRunner.class)
public class FieldMatchValidatorTest {

    private FieldMatchValidator fieldMatchValidator;
    @Mock private FieldMatch fieldMatchMock;
    @Mock private Object objectMock;
    @Mock private BeanUtils beanUtilsMock;
    @Mock private ConstraintValidatorContext constraintValidatorContextMock;
    @Mock private ConstraintValidatorContext.ConstraintViolationBuilder constraintViolationBuilderMock;
    @Mock private ConstraintValidatorContext.ConstraintViolationBuilder.NodeBuilderCustomizableContext nodeBuilderCustomizableContextMock;

    @Before
    public void setUp() throws Exception {
        ConstraintValidatorContext constraintValidatorContextMock = Mockito.mock(ConstraintValidatorContext.class, Mockito.RETURNS_DEEP_STUBS);     //zajebiste
        fieldMatchValidator = new FieldMatchValidator();

        Mockito.when(fieldMatchMock.first()).thenReturn("first");
        Mockito.when(fieldMatchMock.second()).thenReturn("second");
        Mockito.when(fieldMatchMock.message()).thenReturn("message");
        fieldMatchValidator.initialize(fieldMatchMock);
    }

    @Test(expected=Exception.class)
    public void testIsValid() throws Exception {
        //Mockito.when(beanUtilsMock.getProperty(objectMock, "")).thenReturn(objectMock);
        //Mockito.when(constraintValidatorContextMock.buildConstraintViolationWithTemplate(null)).thenReturn(constraintViolationBuilderMock);
        //Mockito.when(constraintViolationBuilderMock.addPropertyNode(null)).thenReturn(nodeBuilderCustomizableContextMock);
        //Mockito.when(nodeBuilderCustomizableContextMock.addConstraintViolation()).thenReturn(constraintValidatorContextMock);
        Mockito.when(constraintValidatorContextMock.buildConstraintViolationWithTemplate(null).addPropertyNode(null).addConstraintViolation()).thenReturn(constraintValidatorContextMock);

        assertFalse(fieldMatchValidator.isValid(objectMock, constraintValidatorContextMock));

        Mockito.verify(constraintValidatorContextMock).disableDefaultConstraintViolation();
        Mockito.verify(constraintValidatorContextMock).buildConstraintViolationWithTemplate(null).addPropertyNode(null).addConstraintViolation();

    }

}
package pl.weztegre.validators;


import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
* Klasa FieldMatchValidator odpowiada za sprawdzanie poprawności wprowadzonych danych
*/
public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {
    private String firstFieldName;
    private String secondFieldName;
    private String messageName;

	/**
	* Metoda initialize ustawia początkowe wartości zmiennych
	* @param contrainAnnotation instancja FieldMatch zawierająca nazwy trzech pól, które należy sprawdzić.
	*/
    @Override
    public void initialize(final FieldMatch constraintAnnotation) {
        firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
        messageName = constraintAnnotation.message();
    }

	/**
	* Metoda sprawdza poprawność podanej wartości
	* @param value Obiekt zawierający nazwę pól do sprawdzenia
	* @param cvc ConstraintValidatorContext
	* @return True lub False
	*/
    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext cvc) {
        boolean toReturn = false;

        try {
            final Object firstObj = BeanUtils.getProperty(value, firstFieldName);
            final Object secondObj = BeanUtils.getProperty(value, secondFieldName);

            //System.out.println("firstObj = "+firstObj+"   secondObj = "+secondObj);

            toReturn = firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
        } catch (final Exception e) {
            System.out.println(e.toString());
        }
        //If the validation failed
        if (!toReturn) {
            cvc.disableDefaultConstraintViolation();
            //In the initialiaze method you get the errorMessage: constraintAnnotation.messageName();
            cvc.buildConstraintViolationWithTemplate(messageName).addPropertyNode(firstFieldName).addConstraintViolation();
        }
        return toReturn;
    }
}
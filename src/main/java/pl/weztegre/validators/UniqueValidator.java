package pl.weztegre.validators;


import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import pl.weztegre.repositories.UserRepository;
import pl.weztegre.services.UserService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.math.BigInteger;

/**
* Klasa UniqueValidator pozwala na sprawdzenie danych pod kontem unikalności.
*/
public class UniqueValidator implements ConstraintValidator<Unique, String> {
    @PersistenceContext
    private EntityManager entityManager;

    private String column;
    private String messageName;
    private Class clas;

	/**
	* Metoda inicjalizująca instancję klasy
	* @param constraintAnnotation Opisy ograniczeń nałożonych na pola.
	*/
    @Override
    public void initialize(final Unique constraintAnnotation) {
        column = constraintAnnotation.column();
        messageName = constraintAnnotation.message();
        clas = constraintAnnotation.clas();
    }

	/**
	* Metoda sprawdzająca poprawność podanej wartości porównując ją z ograniczeniem
	* @param value Sprawdzany string
	* @param cvc ConstraintValidatorContext
	*/
    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext cvc) {
        boolean toReturn = false;

        try {
            // wydobycie z adnotacji @Table wlasciwosci name
            String tableName = null;
            Annotation[] annotations = clas.getDeclaredAnnotations();
            for(Annotation annotation : annotations) {
                if(annotation instanceof Table) {
                    Table tableAnnotation = (Table)annotation;
                    tableName = tableAnnotation.name();
                }
            }

            // sprawdzenie czy istnieje obiekt o takiej wartosci
            StringBuilder query = new StringBuilder();
            query.append("SELECT count(*) FROM ").append(tableName).append(" WHERE ").append(column).append("='").append(value).append("'");
            Number count = (Number)entityManager.createNativeQuery(query.toString()).getSingleResult();

            if(count.intValue() == 0)
                toReturn = true;

        } catch (final Exception e) {
            System.out.println(e.toString());
        }
        if (!toReturn) {
            cvc.disableDefaultConstraintViolation();
            cvc.buildConstraintViolationWithTemplate(messageName)/*.addPropertyNode(column)*/.addConstraintViolation();
        }
        return toReturn;
    }
}
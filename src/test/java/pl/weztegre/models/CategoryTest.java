package pl.weztegre.models;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import pl.weztegre.EqualsTester;

import static org.junit.Assert.*;

/**
 * Created by st3rn on 15.05.15.
 */
@RunWith(MockitoJUnitRunner.class)
public class CategoryTest {

    private Category Category;
    private Category Category2;

    @Before
    public void setUp() throws Exception {
        Category = new Category();
        Category.setId(1);
        Category2 = new Category();
        Category2.setId(2);

    }

    @Test
    public void testEquals() throws Exception {
        EqualsTester<Category> equalsTester = EqualsTester.newInstance(new Category());
        equalsTester.assertEqual(new Category(), new Category());
        equalsTester.assertNotEqual(Category, Category2);
    }

    @Test
    public void testHashCode() throws Exception {
        Category2.setId(1);
        assertTrue(Category.equals(Category2) && Category2.equals(Category));
        assertTrue(Category.hashCode() == Category2.hashCode());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("Category{id=1, name='null', category=null}",
                Category.toString());

    }
}
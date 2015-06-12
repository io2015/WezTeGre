package pl.weztegre.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Created by st3rn on 13.05.15.
 */
//@RunWith(MockitoJUnitRunner.class)
public class NavigationControllerTest {

    private NavigationController navigationController;

    @Before
    public void setUp() throws Exception {
        this.navigationController = new NavigationController();
    }

    @Test
    public void testIndexPage() throws Exception {
        assertEquals("redirect:advertisement/list", navigationController.startPage());
    }
}
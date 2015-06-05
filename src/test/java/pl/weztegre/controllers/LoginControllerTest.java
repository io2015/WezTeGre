package pl.weztegre.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by st3rn on 13.05.15.
 */
//@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {

    private LoginController loginController;

    @Before
    public void setUp() throws Exception {
        loginController = new LoginController();
    }

    @Test
    public void testLoginPage() throws Exception {
        assertEquals("login", loginController.loginPage(null, null).getViewName());
        assertTrue(loginController.loginPage("error", null).getModel().containsKey("error"));
        assertTrue(loginController.loginPage(null, "msg").getModel().containsKey("msg"));
    }
}
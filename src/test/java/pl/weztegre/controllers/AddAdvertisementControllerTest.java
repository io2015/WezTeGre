package pl.weztegre.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import pl.weztegre.formObjects.AdvertisementForm;


import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.*;

/**
 * Created by st3rn on 12.05.15.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(MockitoJUnitRunner.class)
public class AddAdvertisementControllerTest {

    private AddAdvertisementController addAdvertisementController;
    private MockMvc mockMvc;
    @Mock private BindingResult bindingResultMock;
    @Mock private HttpServletRequest httpServletRequestMock;

    @Before
    public void setUp() throws Exception {
        //MockitoAnnotations.initMocks(this);   //nie trzeba jeżeli jest @RunWith Mockito
        addAdvertisementController = new AddAdvertisementController();
    }

    @Test
    public void testAddAdvertisement() throws Exception {   //zwraca ModelAndView
        ModelAndView expectedModelAndView = new ModelAndView("addAdvertisement", "advertisementForm", new AdvertisementForm());
        assertEquals("addAdvertisement", addAdvertisementController.addAdvertisement().getViewName());
    }

    @Test
    public void testAddAdvertisement1() throws Exception {  //zwraca stringa
        AdvertisementForm advertisementForm = new AdvertisementForm();
        assertEquals("addAdvertisement", addAdvertisementController.addAdvertisement(advertisementForm, bindingResultMock, httpServletRequestMock));
        Mockito.verify(bindingResultMock, Mockito.times(2)).hasErrors();  //sprawdź czy hasErrors() zostało wywołane
    }
}
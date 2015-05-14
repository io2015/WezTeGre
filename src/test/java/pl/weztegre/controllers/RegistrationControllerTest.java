package pl.weztegre.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import pl.weztegre.events.OnRegistrationCompleteEvent;
import pl.weztegre.formObjects.UserForm;
import pl.weztegre.models.Registration;
import pl.weztegre.models.User;
import pl.weztegre.services.RegistrationService;

import javax.servlet.http.HttpServletRequest;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static org.junit.Assert.*;

/**
 * Created by st3rn on 13.05.15.
 */
@RunWith(MockitoJUnitRunner.class)
public class RegistrationControllerTest {

    @InjectMocks    //załatwia @Autowired
    private RegistrationController registrationController;
    @Mock private RegistrationService registrationServiceMock;
    @Mock private ApplicationEventPublisher applicationEventPublisherMock;
    @Mock private UserForm userFormMock;
    @Mock private BindingResult bindingResultMock;
    @Mock private HttpServletRequest httpServletRequestMock;
    @Mock private Registration registrationMock;
    @Mock private OnRegistrationCompleteEvent onRegistrationCompleteEventMock;
    @Mock private Model modelMock;
    @Mock private Date dateMock;
    @Mock private User userMock;


    @Before
    public void setUp() throws Exception {
        //registrationController = new RegistrationController();    //tworzy się samo przez InjectMocks
    }

    @Test
    public void testSingUp() throws Exception {
        assertEquals("signup", registrationController.singUp().getViewName());
    }

    @Test
    public void testRegisterUser() throws Exception {
        Mockito.when(registrationServiceMock.createUserAndRegistration(userFormMock)).thenReturn(registrationMock);
        //Mockito.when(httpServletRequestMock.getLocale()).thenReturn(new Locale(""));
        //OnRegistrationCompleteEvent onRegistrationCompleteEvent = new OnRegistrationCompleteEvent(registrationMock, httpServletRequestMock.getLocale(), "");

        assertEquals("registeredSuccessfully", registrationController.registerUser(userFormMock, bindingResultMock, httpServletRequestMock));

        Mockito.verify(bindingResultMock).hasErrors();  //sprawdź czy hasErrors() zostało wywołane
        Mockito.verify(registrationServiceMock).createUserAndRegistration(userFormMock);
        Mockito.verify(applicationEventPublisherMock).publishEvent(Mockito.any(OnRegistrationCompleteEvent.class));
    }

    @Test
    public void testRegisterUserErrors() throws Exception {
        Mockito.when(bindingResultMock.hasErrors()).thenReturn(true);   //gdy coś jest nie tak w formularzu
        assertEquals("signup", registrationController.registerUser(userFormMock, bindingResultMock, httpServletRequestMock));
    }

    @Test
    public void testCofirmRegistration() throws Exception {
        Mockito.when(registrationServiceMock.getRegistrationToken(Mockito.anyString())).thenReturn(registrationMock);
        Mockito.when(registrationMock.getExpiryDate()).thenReturn(dateMock);
        Mockito.when(dateMock.getTime()).thenReturn(Calendar.getInstance().getTime().getTime() + 10000);    //przypadek z aktualnym tokenem
        Mockito.when(registrationMock.getUser()).thenReturn(userMock);

        assertEquals("registrationConfirmed", registrationController.cofirmRegistration(Mockito.anyString(), httpServletRequestMock, modelMock));

        Mockito.verify(userMock).setEnabled(true);
        Mockito.verify(registrationServiceMock).saveUserAndDeleteRegistration(registrationMock);
    }


    @Test
    public void testCofirmRegistrationExpired() throws Exception {
        Mockito.when(registrationServiceMock.getRegistrationToken(Mockito.anyString())).thenReturn(registrationMock);
        Mockito.when(registrationMock.getExpiryDate()).thenReturn(dateMock);
        Mockito.when(dateMock.getTime()).thenReturn(Calendar.getInstance().getTime().getTime() - 1);    //przypadek z przeterminowanym tokenem
        Mockito.when(registrationMock.getUser()).thenReturn(userMock);

        assertEquals("tokenExpired", registrationController.cofirmRegistration(Mockito.anyString(), httpServletRequestMock, modelMock));

        Mockito.verify(registrationServiceMock).updateUserAndRegistration(registrationMock);
        Mockito.verify(applicationEventPublisherMock).publishEvent(Mockito.any(OnRegistrationCompleteEvent.class));
        Mockito.verify(modelMock).addAttribute("user", registrationMock.getUser());
    }
}
package pl.weztegre.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import pl.weztegre.formObjects.UserData;
import pl.weztegre.models.User;
import pl.weztegre.services.UserService;

import java.security.Principal;

import static org.junit.Assert.*;

/**
 * Created by st3rn on 14.05.15.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @InjectMocks private UserController userController;
    @Mock private UserService userServiceMock;
    @Mock private Model modelMock;
    @Mock private Principal principalMock;
    @Mock private User userMock;
    @Mock private UserData userDataMock;
    @Mock private BindingResult bindingResultMock;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testControlPanel() throws Exception {
        //model.addAttribute("nick", userPrincipal.getName());
        assertEquals("controlPanel", userController.controlPanel(null, modelMock, principalMock));

        Mockito.verify(modelMock).addAttribute("nick", principalMock.getName());
    }

    @Test
    public void testControlPanelSuccess() throws Exception {
        assertEquals("controlPanel", userController.controlPanel("success", modelMock, principalMock));

        Mockito.verify(modelMock).addAttribute("nick", principalMock.getName());
        Mockito.verify(modelMock).addAttribute("success", "Dane zostały zmienione");
    }


    @Test
    public void testChangeData() throws Exception {
        /*Mockito.when(userMock.getName()).thenReturn("");
        Mockito.when(userMock.getSurname()).thenReturn("");
        Mockito.when(userMock.getCity()).thenReturn("");
        Mockito.when(userMock.getAddress()).thenReturn("");
        Mockito.when(userMock.getPhoneNumber()).thenReturn("");
        Mockito.when(userMock.getSkype()).thenReturn("");
        Mockito.when(userMock.getGaduGadu()).thenReturn("");*/
        //Mockito.when(principalMock.getName()).thenReturn("");
        Mockito.when(userServiceMock.findByEmail(principalMock.getName())).thenReturn(userMock);

        assertEquals("changeUserData", userController.changeData(modelMock, principalMock));

        Mockito.verify(modelMock).addAttribute(Mockito.eq("userData"), Mockito.any(UserData.class));    //jeżeli choć jeden argument jest z matchera to wszystkie muszą być
        Mockito.verify(modelMock).addAttribute("email", userMock.getEmail());
    }

    @Test
    public void testChangeDataUserContactDetails() throws Exception {
        //User user = userService.findByEmail(userPrincipal.getName());
        Mockito.when(userServiceMock.findByEmail(principalMock.getName())).thenReturn(userMock);

        assertEquals("redirect:/user/controlPanel?success", userController.changeDataUserContactDetails(userDataMock, bindingResultMock, principalMock));

        Mockito.verify(userServiceMock).save(userMock);
    }

    @Test
    public void testChangeDataUserContactDetailsErrors() throws Exception {
        Mockito.when(bindingResultMock.hasErrors()).thenReturn(true);
        //Mockito.when(userServiceMock.findByEmail(principalMock.getName())).thenReturn(userMock);

        assertEquals("changeUserData", userController.changeDataUserContactDetails(userDataMock, bindingResultMock, principalMock));
    }

}
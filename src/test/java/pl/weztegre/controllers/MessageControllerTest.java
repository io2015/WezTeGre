package pl.weztegre.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import pl.weztegre.formObjects.MessageForm;
import pl.weztegre.jsons.MessageJSON;
import pl.weztegre.models.Message;
import pl.weztegre.models.User;
import pl.weztegre.services.MessageService;
import pl.weztegre.services.UserService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by st3rn on 12.06.15.
 */
@RunWith(MockitoJUnitRunner.class)
public class MessageControllerTest {

    @Mock private UserService userServiceMock;
    @Mock private MessageService messageServiceMock;
    @Mock private Model modelMock;
    @Mock private Message messageMock;
    @Mock private MessageForm messageFormMock;
    @Mock private BindingResult bindingResultMock;
    @Mock private Principal principalMock;
    @Mock private User userMock;
    @Mock private MessageJSON messageJSONMock;
    @InjectMocks private MessageController messageController;

    @Before
    public void setUp() throws Exception {
        //messageController = new MessageController();
        messageFormMock = Mockito.mock(MessageForm.class, Mockito.RETURNS_DEEP_STUBS);     //zajebiste
    }

    @Test
    public void testAddPage() throws Exception {
        List<User> userList = new ArrayList<User>();

        Mockito.doReturn(userList).when(userServiceMock).findAll();

        Mockito.when(userServiceMock.findAll()).thenReturn(userList);
        assertEquals("addMessage", messageController.addPage(modelMock));
        Mockito.verify(modelMock).addAttribute("users", userServiceMock.findAll());
    }

    @Test
    public void testShowPage() throws Exception {
        Mockito.when(messageServiceMock.findOne(0)).thenReturn(messageMock);
        assertEquals("message", messageController.showPage(0, modelMock));
        Mockito.verify(modelMock).addAttribute("message", messageServiceMock.findOne(0));
    }

    @Test
    public void testAddMessage() throws Exception {
        Mockito.when(bindingResultMock.hasErrors()).thenReturn(false);
        Mockito.when(principalMock.getName()).thenReturn("asdf");
        Mockito.when(userServiceMock.findByEmail("asdf")).thenReturn(userMock);
        Mockito.when(userServiceMock.findOne(0)).thenReturn(userMock);
        Mockito.when(messageFormMock.getAddressee().getId()).thenReturn(0);
        Mockito.when(messageMock.getId()).thenReturn(0);

        /*messageController.addMessage(messageFormMock, bindingResultMock, principalMock);
        Mockito.verify(userServiceMock).findByEmail("asdf");
        Mockito.verify(userServiceMock).findOne(0);
        Mockito.verify(messageJSONMock).setRedirect("message/"+0);*/
        //User addressee = userService.findOne(messageForm.getAddressee().getId());
    }

    @Test
    public void testAddMessageErrors() throws Exception {
        Mockito.when(bindingResultMock.hasErrors()).thenReturn(true);
        Mockito.when(principalMock.getName()).thenReturn("asdf");
        messageController.addMessage(messageFormMock, bindingResultMock, principalMock);
    }

    @Test
    public void testListMessages() throws Exception {
        List<Message> messageList = new ArrayList<Message>();
        Mockito.doReturn(messageList).when(messageServiceMock).findByIdOrderByDateDescTimeDesc(userMock);

        Mockito.when(userServiceMock.findByEmail("asdf")).thenReturn(userMock);
        Mockito.when(principalMock.getName()).thenReturn("asdf");
        //Mockito.when(messageServiceMock.findByIdOrderByDateDescTimeDesc(userMock)).thenReturn();
        assertEquals("listOfMessages", messageController.listMessages(modelMock, principalMock));
        Mockito.verify(modelMock).addAttribute("messages", messageServiceMock.findByIdOrderByDateDescTimeDesc(userMock));
    }
}
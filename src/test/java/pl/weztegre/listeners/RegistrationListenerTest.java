package pl.weztegre.listeners;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.omg.CORBA.Environment;
import org.springframework.context.MessageSource;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import pl.weztegre.events.OnRegistrationCompleteEvent;
import pl.weztegre.models.Registration;
import pl.weztegre.models.User;
import pl.weztegre.services.UserService;

import static org.junit.Assert.*;

/**
 * Created by st3rn on 14.05.15.
 */
@RunWith(MockitoJUnitRunner.class)
public class RegistrationListenerTest {

    @InjectMocks private RegistrationListener registrationListener;
    @Mock private UserService userServiceMock;
    @Mock private MessageSource messageSourceMock;
    @Mock private JavaMailSender javaMailSenderMock;
    @Mock private org.springframework.core.env.Environment environmentMock;
    @Mock private ApplicationEventMulticaster applicationEventMulticasterMock;
    @Mock private User userMock;
    @Mock private OnRegistrationCompleteEvent onRegistrationCompleteEventMock;
    @Mock private Registration registrationMock;

    @Test
    public void testOnApplicationEvent() throws Exception {
        //OnRegistrationCompleteEvent onRegistrationCompleteEvent = new OnRegistrationCompleteEvent();
        Mockito.when(onRegistrationCompleteEventMock.getRegistration()).thenReturn(registrationMock);
        Mockito.when(registrationMock.getUser()).thenReturn(userMock);
        Mockito.when(registrationMock.getToken()).thenReturn("");
        Mockito.when(environmentMock.getProperty("support.email")).thenReturn(null);

        registrationListener.onApplicationEvent(onRegistrationCompleteEventMock);

        Mockito.verify(javaMailSenderMock).send(Mockito.any(SimpleMailMessage.class));
    }
}
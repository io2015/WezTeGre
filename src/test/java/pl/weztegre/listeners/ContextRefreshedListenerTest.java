package pl.weztegre.listeners;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.event.ContextRefreshedEvent;
import pl.weztegre.services.*;

import static org.junit.Assert.*;

/**
 * Created by st3rn on 14.05.15.
 */
@RunWith(MockitoJUnitRunner.class)
public class ContextRefreshedListenerTest {

    @InjectMocks private ContextRefreshedListener contextRefreshedListener;
    @Mock private RoleService roleServiceMock;
    @Mock private ContextRefreshedEvent contextRefreshedEventMock;
    @Mock private PlatformService platformServiceMock;
    @Mock private LanguageService languageServiceMock;
    @Mock private DistributionService distributionServiceMock;
    @Mock private GameService gameServiceMock;
    @Mock private GenreService genreServiceMock;

    @Test
    public void testOnApplicationEvent() throws Exception {
        contextRefreshedListener.onApplicationEvent(contextRefreshedEventMock);
        Mockito.verify(roleServiceMock).findRole("ROLE_USER");
        Mockito.verify(roleServiceMock).findRole("ROLE_ADMIN");
        Mockito.verify(roleServiceMock).createRole("ROLE_USER");
        Mockito.verify(roleServiceMock).createRole("ROLE_ADMIN");

        contextRefreshedListener.onApplicationEvent(contextRefreshedEventMock);
        Mockito.verifyNoMoreInteractions(roleServiceMock);  //bo configured = true
    }
}
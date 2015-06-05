package pl.weztegre.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import pl.weztegre.models.User;
import pl.weztegre.repositories.RoleRepository;
import pl.weztegre.repositories.UserRepository;

import static org.junit.Assert.*;

/**
 * Created by st3rn on 15.05.15.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @InjectMocks private UserServiceImpl userServiceImpl;
    @Mock private UserRepository userRepositoryMock;
    @Mock private User userMock;

    @Test
    public void testFindAll() throws Exception {
        userServiceImpl.findAll();
        Mockito.verify(userRepositoryMock).findAll();
    }

    @Test
    public void testSave() throws Exception {
        userServiceImpl.save(userMock);
        Mockito.verify(userRepositoryMock).save(userMock);
    }

    @Test
    public void testFindByEmail() throws Exception {
        userServiceImpl.findByEmail("email");
        Mockito.verify(userRepositoryMock).findByEmail("email");
    }
}
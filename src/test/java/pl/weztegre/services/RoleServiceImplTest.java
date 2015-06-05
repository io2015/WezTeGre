package pl.weztegre.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import pl.weztegre.controllers.RegistrationController;
import pl.weztegre.models.Role;
import pl.weztegre.repositories.RoleRepository;

import static org.junit.Assert.*;

/**
 * Created by st3rn on 15.05.15.
 */
@RunWith(MockitoJUnitRunner.class)
public class RoleServiceImplTest {

    @InjectMocks private RoleServiceImpl roleServiceImpl;
    @Mock private RoleRepository roleRepositoryMock;

    @Test
    public void testFindRole() throws Exception {
        roleServiceImpl.findRole("role");
        Mockito.verify(roleRepositoryMock).findByRole("role");
    }

    @Test
    public void testCreateRole() throws Exception {
        roleServiceImpl.createRole("role");
        Mockito.verify(roleRepositoryMock).save(Mockito.any(Role.class));  //sprawdź czy hasErrors() zostało wywołane

    }
}
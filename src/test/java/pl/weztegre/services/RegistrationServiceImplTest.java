package pl.weztegre.services;

import org.junit.Before;
import org.junit.Test;
import pl.weztegre.formObjects.UserForm;
import pl.weztegre.models.Registration;
import pl.weztegre.models.User;
import pl.weztegre.repositories.RegistrationRepository;
import pl.weztegre.repositories.RoleRepository;
import pl.weztegre.repositories.UserRepository;
import static org.easymock.EasyMock.*;

import static org.junit.Assert.*;

/**
 * Created by st3rn on 11.05.15.
 * Kod każdego testu podzielony na 3 części:
 * - ustawianie mocków
 * - replay mocków, ustawianie reszty zmiennych, wywoływanie metod, itd.
 * - weryfikacje i asercje
 */
public class RegistrationServiceImplTest {

    private RegistrationService registrationService;
    private UserRepository mockUserRepository;
    private RegistrationRepository mockRegistrationRepository;
    private RoleRepository mockRoleRepository;
    private User user;
    private Registration registration;

    @Before
    public void setUp() throws Exception {
        //repository mocks
        mockUserRepository = createMock(UserRepository.class);
        mockRegistrationRepository = createMock(RegistrationRepository.class);
        mockRoleRepository = createMock(RoleRepository.class);

        //reszta żeby nie przepisywać w każdym teście
        user = new User("asdf@asdf.asdf", "asdf", "asdf", "asdf");
        registration = new Registration(user, "");
        registrationService = new RegistrationServiceImpl();    //nie jest Impl bo to interfejs
    }

    @Test
    public void testCreateUserAndRegistration() throws Exception {

        expect(mockRoleRepository.findByRole("ROLE_USER")).atLeastOnce();     //check if user role is set
        expect(mockRegistrationRepository.save(registration)).andReturn(registration);
        registrationService.setRoleRepository(mockRoleRepository);
        registrationService.setRegistrationRepository(mockRegistrationRepository);

        replay(mockRegistrationRepository);
        replay(mockRoleRepository);
        UserForm userForm = new UserForm("asdf@asdf.asdf", "asdf", "asdf", "asdf", "asdf");
        Registration actualRegistration = registrationService.createUserAndRegistration(userForm);
        User actualUser = actualRegistration.getUser();

        assertEquals(new User("asdf@asdf.asdf", "asdf", "asdf", "asdf"), actualUser);   //check if user is created correctly
        //assertEquals(,actualUser.getRoles());     //check if user role is maintained
        verify(mockRoleRepository);
    }

    @Test
    public void testUpdateUserAndRegistration() throws Exception {
        expect(mockRegistrationRepository.save(registration)).andReturn(registration);
        registrationService.setRegistrationRepository(mockRegistrationRepository);

        replay(mockRegistrationRepository);
        Registration actualRegistration = registrationService.updateUserAndRegistration(registration);

        verify(mockRegistrationRepository);
        assertEquals(registration, actualRegistration);

    }

    @Test
    public void testSaveUserAndDeleteRegistration() throws Exception {
        expect(mockUserRepository.save(registration.getUser())).andReturn(user);
        mockRegistrationRepository.delete(registration);    //jest void, dlatego expect poniżej
        expectLastCall().atLeastOnce();
        registrationService.setRegistrationRepository(mockRegistrationRepository);
        registrationService.setUserRepository(mockUserRepository);

        replay(mockUserRepository);
        replay(mockRegistrationRepository);
        User tempUsr = registrationService.saveUserAndDeleteRegistration(registration);

        verify(mockRegistrationRepository);
        verify(mockUserRepository);
        assertEquals(user, tempUsr);
    }

    @Test
    public void testGetRegistrationToken() throws Exception {
        expect(mockRegistrationRepository.findByToken("")).andReturn(registration);
        registrationService.setRegistrationRepository(mockRegistrationRepository);

        replay(mockRegistrationRepository);
        Registration actualRegistration = registrationService.getRegistrationToken("");

        verify(mockRegistrationRepository);
        assertEquals(registration, actualRegistration);
    }
}
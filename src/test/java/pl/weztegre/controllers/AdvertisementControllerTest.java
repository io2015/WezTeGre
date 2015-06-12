package pl.weztegre.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import pl.weztegre.enums.State;
import pl.weztegre.formObjects.AdvertisementForm;
import pl.weztegre.models.Advertisement;
import pl.weztegre.services.*;


import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by st3rn on 12.05.15.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(MockitoJUnitRunner.class)
public class AdvertisementControllerTest {

    @InjectMocks private AdvertisementController AdvertisementController;
    private MockMvc mockMvc;
    @Mock private BindingResult bindingResultMock;
    @Mock private HttpServletRequest httpServletRequestMock;
    @Mock private AdvertisementService advertisementServiceMock;
    @Mock private DistributionService distributionServiceMock;
    @Mock private LanguageService languageServiceMock;
    @Mock private PlatformService platformServiceMock;
    @Mock private GameService gameServiceMock;
    @Mock private GenreService genreServiceMock;
    @Mock private Model modelMock;

    @Before
    public void setUp() throws Exception {
        //MockitoAnnotations.initMocks(this);   //nie trzeba jeżeli jest @RunWith Mockito
        AdvertisementController = new AdvertisementController();
        modelMock = Mockito.mock(Model.class, Mockito.RETURNS_DEEP_STUBS);     //zajebiste
        distributionServiceMock = Mockito.mock(DistributionService.class, Mockito.RETURNS_DEEP_STUBS);     //zajebiste
    }

    //@Test
    //public void test() {}
    @Test
    public void testIndexPage() {
        /*assertEquals("listOfAdvertisements", AdvertisementController.indexPage(modelMock));
        Mockito.when(advertisementServiceMock.findAll()).thenReturn(new List<Advertisement>());
        Mockito.verify(modelMock).addAttribute("advertisements", advertisementServiceMock.findAll());
        Mockito.verify(modelMock).addAttribute("genres", genreServiceMock.findAll());
        Mockito.verify(modelMock).addAttribute("games", gameServiceMock.findAll());*/
    }

    @Test
    public void testAddAdvertisement() {
        /*assertEquals("addAdvertisement", AdvertisementController.addAdvertisement(modelMock));
        Mockito.verify(modelMock).addAttribute("advertisementForm", new AdvertisementForm());
        Mockito.verify(modelMock).addAttribute("distributions", distributionServiceMock.findAll());
        Mockito.verify(modelMock).addAttribute("languages", languageServiceMock.findAll());
        Mockito.verify(modelMock).addAttribute("platforms", platformServiceMock.findAll());
        Mockito.verify(modelMock).addAttribute("games", gameServiceMock.findAll());
        Mockito.verify(modelMock).addAttribute("states", State.values());*/
    }
}
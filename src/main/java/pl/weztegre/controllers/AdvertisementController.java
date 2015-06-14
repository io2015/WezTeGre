package pl.weztegre.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import pl.weztegre.enums.State;
import pl.weztegre.formObjects.AdvertisementForm;
import pl.weztegre.formObjects.PhotoForm;
import pl.weztegre.jsons.AdvertisementFilterJSON;
import pl.weztegre.jsons.AdvertisementJSON;
import pl.weztegre.models.Advertisement;
import pl.weztegre.models.Game;
import pl.weztegre.models.GameForExchange;
import pl.weztegre.models.Photo;
import pl.weztegre.pojos.AdvertisementPOJO;
import pl.weztegre.services.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping(value = "/advertisement")
public class AdvertisementController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AdvertisementController.class);

    @Autowired
    private AdvertisementService advertisementService;

    @Autowired
    private DistributionService distributionService;

    @Autowired
    private LanguageService languageService;

    @Autowired
    private PlatformService platformService;

    @Autowired
    private GameService gameService;

    @Autowired
    private GenreService genreService;

    /**
     * Mapowanie na /.
     * Metoda kontrolera odpowiedzialna za przekierowanie do strony głównej.
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String indexPage(Model model) {
        model.addAttribute("advertisements", advertisementService.findAll());
        model.addAttribute("genres", genreService.findAll());
        model.addAttribute("games", gameService.findAll());

        return "listOfAdvertisements";
    }

    @RequestMapping(value = "/list/filter", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Advertisement> filter(@RequestBody AdvertisementFilterJSON advertisementFilterJSON) {
        List<Advertisement> advertisements = null;

        if(advertisementFilterJSON.getInDescription() && advertisementFilterJSON.getInTitle())
            advertisements = advertisementService.findByTitleOrContentOrGame(advertisementFilterJSON.getFind());
        else if(!advertisementFilterJSON.getInDescription() && !advertisementFilterJSON.getInTitle())
            advertisements = advertisementService.findByTitle(advertisementFilterJSON.getFind());
        else if(!advertisementFilterJSON.getInDescription() && advertisementFilterJSON.getInTitle())
            advertisements = advertisementService.findByTitleOrGame(advertisementFilterJSON.getFind());
        else if(advertisementFilterJSON.getInDescription() && !advertisementFilterJSON.getInTitle())
            advertisements = advertisementService.findByTitleOrContent(advertisementFilterJSON.getFind());

        return advertisements;
    }

	/**
	* Metoda dodająca ogłoszenie,
	* @param model Model ogłoszenia
	*/
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addAdvertisement(Model model) {
        model.addAttribute("advertisementForm", new AdvertisementForm());
        model.addAttribute("distributions", distributionService.findAll());
        model.addAttribute("languages", languageService.findAll());
        model.addAttribute("platforms", platformService.findAll());
        model.addAttribute("games", gameService.findAll());
        model.addAttribute("states", State.values());

        return "addAdvertisement";
    }

	/**
	* Metoda pobiera ogłoszenie
	* @param id ID ogłoszenia do pobrania
	* @param model Model ogłoszenia
	*/
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String advertisement(@PathVariable Integer id, Model model) throws InterruptedException {
        AdvertisementPOJO advertisement = advertisementService.findOne(id);

        prepareAdvertisement(advertisement);

        List<String> photos = getPhotosFromAdvertisement(advertisement);

        model.addAttribute("advertisement", advertisement);
        model.addAttribute("photos", photos);
        model.addAttribute("id", id);

        return "advertisement";
    }

	/**
	* Metoda przygotowuje ogłoszenie do wysłania
	*/
    private void prepareAdvertisement(AdvertisementPOJO advertisement) {

        for(int i = 0; i < advertisement.getGamesForExchange().size(); i++) {
            for(int j = 0; j < advertisement.getGamesForExchange().size(); j++) {
                if(i != j && advertisement.getGamesForExchange().get(i) == advertisement.getGamesForExchange().get(j)) {
                    advertisement.getGamesForExchange().remove(advertisement.getGamesForExchange().get(j));
                }
            }
        }

        for(int i = 0; i < advertisement.getPhotos().size(); i++) {
            for(int j = 0; j < advertisement.getPhotos().size(); j++) {
                if(i != j && advertisement.getPhotos().get(i) == advertisement.getPhotos().get(j)) {
                    advertisement.getPhotos().remove(advertisement.getPhotos().get(j));
                }
            }
        }
    }

	/**
	* Metoda pobiera obrazki z ogłoszenia
	*/
    private List<String> getPhotosFromAdvertisement(AdvertisementPOJO advertisement) {

        List<String> photos = new LinkedList<String>();

        for(Photo item : advertisement.getPhotos()) {
            photos.add(new String(item.getPhoto()));
        }

        return photos;
    }

	/**
	* Metoda edytuje ogłoszenie
	*/
    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String advertisementEdit(@PathVariable Integer id, Model model) throws InterruptedException {
        AdvertisementPOJO advertisement = advertisementService.findOne(id);

        prepareAdvertisement(advertisement);

        List<String> photos = getPhotosFromAdvertisement(advertisement);

        model.addAttribute("advertisement", advertisement);
        model.addAttribute("photos", photos);

        model.addAttribute("distributions", distributionService.findAll());
        model.addAttribute("languages", languageService.findAll());
        model.addAttribute("platforms", platformService.findAll());
        model.addAttribute("games", gameService.findAll());
        model.addAttribute("states", State.values());
        model.addAttribute("id", id);

        return "editAdvertisement";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    @ResponseBody
    public AdvertisementJSON editAdvertisment(@Valid @RequestBody AdvertisementForm advertisementForm, @PathVariable Integer id, BindingResult result) {
        AdvertisementJSON advertisementJSON = new AdvertisementJSON();
        if(!result.hasErrors()) {
            //Game game = gameService.findOne(advertisementForm.getGame().getId());

            processAdvertisementForm(advertisementForm);

            List<Photo> photos = getPhotosFromAdvertisementForm(advertisementForm);

            Advertisement advertisement = advertisementService.findOneNormal(id);
            advertisement.setTitle(advertisementForm.getTitle());
            advertisement.setContent(advertisementForm.getContent());
            advertisement.setState(advertisementForm.getState());
            advertisement.setDistribution(distributionService.findByDistribution(advertisementForm.getDistribution().getDistribution()));
            advertisement.setLanguage(languageService.findByLanguage(advertisementForm.getLanguage().getLanguage()));
            advertisement.setPlatform(platformService.findByPlatform(advertisementForm.getPlatform().getPlatform()));
            advertisement.setGamesForExchange(advertisementForm.getGamesForExchange());
            advertisement.setPhotos(photos);

            try {
                advertisement = advertisementService.save(advertisement);
            } catch (Exception e) {
                LOGGER.info(e.getMessage());
                e.printStackTrace();
            }

            advertisementJSON.setRedirect("advertisement/" + advertisement.getId());
        } else {
            processResultError(result, advertisementJSON);
        }

        return advertisementJSON;
    }

	
	/**
	* Metoda przetwarza ogłoszenie
	*/
    private void processAdvertisementForm(AdvertisementForm advertisementForm) {

        for(GameForExchange item : advertisementForm.getGamesForExchange()) {
            item.setGame(gameService.findOne(item.getGame().getId()));
            item.setDistribution(distributionService.findByDistribution(item.getDistribution().getDistribution()));
            item.setLanguage(languageService.findByLanguage(item.getLanguage().getLanguage()));
            item.setPlatform(platformService.findByPlatform(item.getPlatform().getPlatform()));
        }
    }

	/**
	* Metoda pobiera obrazki z formularza ogłoszenia
	* @param advertisementForm formularz
	* @return Lista obrazków
	*/
    private List<Photo> getPhotosFromAdvertisementForm(AdvertisementForm advertisementForm) {

        List<Photo> photos = new LinkedList<Photo>();

        for(PhotoForm item : advertisementForm.getPhotos()) {
            photos.add(new Photo(item.getPhoto()));
        }

        return photos;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    @ResponseBody
    public AdvertisementJSON addAdvertisment(@Valid @RequestBody AdvertisementForm advertisementForm, BindingResult result) {
        AdvertisementJSON advertisementJSON = new AdvertisementJSON();
        if(!result.hasErrors()) {



            Date time = Calendar.getInstance().getTime();

            Calendar end = Calendar.getInstance();
            end.add(Calendar.DATE, 7);
            Date endTime = end.getTime();

            Game game = gameService.findOne(advertisementForm.getGame().getId());

            processAdvertisementForm(advertisementForm);

            List<Photo> photos = getPhotosFromAdvertisementForm(advertisementForm);

            Advertisement advertisement = new Advertisement(
                    advertisementForm.getTitle(),
                    advertisementForm.getContent(),
                    advertisementForm.getState(),
                    game,
                    time,
                    time,
                    endTime,
                    endTime,
                    distributionService.findByDistribution(advertisementForm.getDistribution().getDistribution()),
                    languageService.findByLanguage(advertisementForm.getLanguage().getLanguage()),
                    platformService.findByPlatform(advertisementForm.getPlatform().getPlatform()),
                    advertisementForm.getGamesForExchange(),
                    photos
            );

            try {
                advertisement = advertisementService.save(advertisement);
            } catch (Exception e) {
                LOGGER.info(e.getMessage());
                e.printStackTrace();
            }

            advertisementJSON.setRedirect("advertisement/" + advertisement.getId());
        } else {
            processResultError(result, advertisementJSON);
        }

        return advertisementJSON;
    }

	/**
	* Metoda przetwarza komunikat o błędze
	*/
    private void processResultError(BindingResult result, AdvertisementJSON advertisementJSON) {

        for(Object item : result.getAllErrors()) {
            if(item instanceof FieldError) {
                FieldError fieldError = (FieldError) item;

                if(fieldError.getField().contains("title"))
                    advertisementJSON.setTitleError(fieldError.getDefaultMessage());
                else if(fieldError.getField().contains("content"))
                    advertisementJSON.setContentError(fieldError.getDefaultMessage());
            }
        }
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(MultipartHttpServletRequest request/*, HttpServletResponse response*/) {
        Iterator<String> itr =  request.getFileNames();
        MultipartFile mpf = null;

        String contentType = null;
        byte[] bytes = null;
        while(itr.hasNext()){
            mpf = request.getFile(itr.next());

            try {
                bytes = Base64.encode(mpf.getBytes());
                contentType = mpf.getContentType();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                LOGGER.info(e.getMessage());
                e.printStackTrace();
            }

        }
        return "data:" + contentType + ";base64," + new String(bytes);
    }
}

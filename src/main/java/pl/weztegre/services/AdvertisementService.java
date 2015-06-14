package pl.weztegre.services;

import pl.weztegre.models.Advertisement;
import pl.weztegre.pojos.AdvertisementPOJO;

import java.util.List;

public interface AdvertisementService {
        Advertisement save(Advertisement advertisement);
        List<Advertisement> findAll();
        AdvertisementPOJO findOne(Integer id);
        Advertisement findOneNormal(Integer id);
        List<Advertisement> findByTitleOrContentOrGame(String filter);
        List<Advertisement> findByTitle(String filter);
        List<Advertisement> findByTitleOrContent(String filter);
        List<Advertisement> findByTitleOrGame(String filter);
}

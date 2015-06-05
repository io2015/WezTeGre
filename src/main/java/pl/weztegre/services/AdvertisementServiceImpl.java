package pl.weztegre.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.weztegre.models.Advertisement;
import pl.weztegre.pojos.AdvertisementPOJO;
import pl.weztegre.repositories.AdvertisementRepository;

import java.util.List;


@Service
@Transactional
public class AdvertisementServiceImpl implements AdvertisementService {
    private final Logger LOGGER = LoggerFactory.getLogger(AdvertisementServiceImpl.class);

    @Autowired
    private AdvertisementRepository advertisementRepository;

    @Override
    public Advertisement save(Advertisement advertisement) {
        return advertisementRepository.save(advertisement);
    }

    @Override
    public List<Advertisement> findAll() {
        return advertisementRepository.findAll();
    }

    @Override
    public AdvertisementPOJO findOne(Integer id) {
        return new AdvertisementPOJO(advertisementRepository.findOne(id));
    }

    @Override
    public Advertisement findOneNormal(Integer id) {
        return advertisementRepository.findOne(id);
    }

    @Override
    public List<Advertisement> findByTitleOrContentOrGame(String filter) {
        return advertisementRepository.findByTitleOrContentOrGame(filter);
    }

    @Override
    public List<Advertisement> findByTitle(String filter) {
        return advertisementRepository.findByTitle(filter);
    }

    @Override
    public List<Advertisement> findByTitleOrContent(String filter) {
        return advertisementRepository.findByTitleOrContent(filter);
    }

    @Override
    public List<Advertisement> findByTitleOrGame(String filter) {
        return advertisementRepository.findByTitleOrGame(filter);
    }

}

package pl.weztegre.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.weztegre.models.Platform;
import pl.weztegre.models.Role;
import pl.weztegre.repositories.PlatformRepository;
import pl.weztegre.repositories.RoleRepository;

import java.util.List;


@Service
@Transactional
public class PlatformServiceImpl implements PlatformService {
    private final Logger LOGGER = LoggerFactory.getLogger(PlatformServiceImpl.class);

    @Autowired
    private PlatformRepository platformRepository;

    @Override
    public List<Platform> findAll() {
        return platformRepository.findAll();
    }

    @Override
    public Platform findByPlatform(String platform) {
        return platformRepository.findByPlatform(platform);
    }

    @Override
    public void createPlatform(String platform) {
        platformRepository.save(new Platform(platform));
    }
}

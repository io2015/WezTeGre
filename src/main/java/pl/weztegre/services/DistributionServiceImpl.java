package pl.weztegre.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.weztegre.models.Distribution;
import pl.weztegre.models.Language;
import pl.weztegre.repositories.DistributionRepository;
import pl.weztegre.repositories.LanguageRepository;

import java.util.List;


@Service
@Transactional
public class DistributionServiceImpl implements DistributionService {
    private final Logger LOGGER = LoggerFactory.getLogger(DistributionServiceImpl.class);

    @Autowired
    private DistributionRepository distributionRepository;

    @Override
    public Distribution findByDistribution(String distribution) {
        return distributionRepository.findByDistribution(distribution);
    }

    @Override
    public void createDistribution(String distribution) {
        distributionRepository.save(new Distribution(distribution));
    }

    @Override
    public List<Distribution> findAll() {
        return distributionRepository.findAll();
    }
}

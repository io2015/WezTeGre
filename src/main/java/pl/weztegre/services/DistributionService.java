package pl.weztegre.services;

import pl.weztegre.models.Distribution;
import pl.weztegre.models.Language;

import java.util.List;

public interface DistributionService {
        Distribution findByDistribution(String distribution);
        void createDistribution(String distribution);
        List<Distribution> findAll();
}

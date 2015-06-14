package pl.weztegre.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.weztegre.models.Distribution;

public interface DistributionRepository extends JpaRepository<Distribution, Integer> {
    Distribution findByDistribution(String distribution);
}

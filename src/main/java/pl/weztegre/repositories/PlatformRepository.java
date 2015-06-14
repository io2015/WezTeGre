package pl.weztegre.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.weztegre.models.Platform;

public interface PlatformRepository extends JpaRepository<Platform, Integer> {
    Platform findByPlatform(String platform);
}

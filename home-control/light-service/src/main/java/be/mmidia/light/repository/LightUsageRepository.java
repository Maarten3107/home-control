package be.mmidia.light.repository;

import be.mmidia.light.model.LightUsage;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LightUsageRepository extends JpaRepository<LightUsage, UUID> {
    List<LightUsage> findByLightId(String lightId);

    /*@Query("SELECT lu from LightUsage lu where lightId = :lightId")
    List<LightUsage> findUsagesById(String lightId);*/
}

package be.mmidia.light.repository;

import be.mmidia.light.model.LightUsage;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LightUsageRepository extends JpaRepository<LightUsage, Long> {
    List<LightUsage> findByLightId(final Long lightId);

    @Query("select lu1 from LightUsage lu1 where lu1.light.id = :lightId and lu1.startTime = (select max(lu2.startTime) from LightUsage lu2 where lu2.light.id = :lightId and lu2.endTime is null)")
    Optional<LightUsage> findLastUsageByLightId(final Long lightId);
}

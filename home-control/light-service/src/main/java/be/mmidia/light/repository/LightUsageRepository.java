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

    @Query("select lu from LightUsage lu where lu.lightId = :lightId and lu.startTime = (select max(ll.startTime) from LightUsage ll where ll.lightId = :lightId and end_time is null)")
    Optional<LightUsage> findLastUsageById(final Long lightId);

    /*@Query("select lu from LightUsage lu where lightId = :lightId")
    List<LightUsage> findUsagesById(String lightId);*/
}

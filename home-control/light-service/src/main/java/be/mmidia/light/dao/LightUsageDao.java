package be.mmidia.light.dao;

import be.mmidia.light.model.LightUsage;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.springframework.stereotype.Repository;

public interface LightUsageDao {
    void createUsage(final LightUsage lightUsage);

    void updateUsage(final LightUsage lightUsage);

    LightUsage getUsageByLightUsageId(final UUID lightUsageId);

    Set<LightUsage> getUsagesByLightId(final String lightId);
}

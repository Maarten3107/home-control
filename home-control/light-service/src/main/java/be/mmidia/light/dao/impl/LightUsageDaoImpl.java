package be.mmidia.light.dao.impl;

import be.mmidia.light.dao.LightUsageDao;
import be.mmidia.light.model.LightUsage;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public class LightUsageDaoImpl implements LightUsageDao {
    @Override
    public void createUsage(final LightUsage lightUsage) {

    }

    @Override
    public void updateUsage(final LightUsage lightUsage) {

    }

    @Override
    public LightUsage getUsageByLightUsageId(final UUID lightUsageId) {
        return null;
    }

    @Override
    public List<LightUsage> getUsagesByLightId(final String lightId) {
        // Get usages where lightId = lightId
        return null;
    }
}

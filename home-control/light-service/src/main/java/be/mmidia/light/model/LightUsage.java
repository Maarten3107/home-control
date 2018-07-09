package be.mmidia.light.model;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.joda.time.DateTime;

@Entity
public class LightUsage {
    @Id
    private UUID id;

    private DateTime startTime;
    private DateTime endTime;

    private String lightId;

    public LightUsage(final String lightId) {
        this.id = UUID.randomUUID();
        this.startTime = DateTime.now();
        this.lightId = lightId;
    }

    public UUID getId() {
        return id;
    }

    public DateTime getStartTime() {
        return startTime;
    }

    public DateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(final DateTime endTime) {
        this.endTime = endTime;
    }

    public String getLightId() {
        return lightId;
    }
}

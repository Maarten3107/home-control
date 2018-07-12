package be.mmidia.light.model;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

@Entity
@Getter
@Setter
public class LightUsage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private DateTime startTime;
    private DateTime endTime;

    @ManyToOne(targetEntity = Light.class)
    private long lightId;

    /*public LightUsage(final String lightId) {
        this.id = UUID.randomUUID();
        this.startTime = DateTime.now();
        this.lightId = lightId;
    }*/
}

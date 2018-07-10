package be.mmidia.light.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.joda.time.DateTime;

//@Entity
public class Membership implements Serializable {
    @Id
    /*@ManyToOne
    @JoinColumn*/
    private String lightId;

    @Id
    /*@ManyToOne
    @JoinColumn*/
    private String groupId;

    private DateTime creationDate;

    /*public Membership(final String lightId, final String groupId) {
        this.lightId = lightId;
        this.groupId = groupId;
    }*/

    public String getLightId() {
        return lightId;
    }

    public void setLightId(String lightId) {
        this.lightId = lightId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public DateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(DateTime creationDate) {
        this.creationDate = creationDate;
    }
}

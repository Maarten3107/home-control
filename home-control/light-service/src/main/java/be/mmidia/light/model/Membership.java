package be.mmidia.light.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

/*@Entity
@Getter
@Setter
@Table(name = "membership")*/
public class Membership implements Serializable {
    @Id
    //@ManyToOne(targetEntity = Light.class)
    private long lightId;

    @Id
    //@ManyToOne(targetEntity = Group.class)
    private long groupId;

    private DateTime creationDate;

    /*public Membership(final String lightId, final String groupId) {
        this.lightId = lightId;
        this.groupId = groupId;
    }*/
}

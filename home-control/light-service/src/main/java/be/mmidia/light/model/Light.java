package be.mmidia.light.model;

import java.util.Set;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.joda.time.DateTime;

@Entity
public class Light {
    @Id
    private String id;
    private String brandAndType;
    private DateTime purchaseDate;
    private DateTime inUseSince;
    private UUID lastUsage;
    private State state;

    //@OneToMany(mappedBy = "light")
    //private Set<Membership> memberships;

    public Light(final String id, final DateTime purchaseDate) {
        this.id = id;
        this.purchaseDate = purchaseDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrandAndType() {
        return brandAndType;
    }

    public void setBrandAndType(String brandAndType) {
        this.brandAndType = brandAndType;
    }

    public DateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(DateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public DateTime getInUseSince() {
        return inUseSince;
    }

    public void setInUseSince(DateTime inUseSince) {
        this.inUseSince = inUseSince;
    }

    public UUID getLastUsage() {
        return lastUsage;
    }

    public void setLastUsage(UUID lastUsage) {
        this.lastUsage = lastUsage;
    }

    /*public Set<Membership> getMemberships() {
        return memberships;
    }

    public void setMemberships(Set<Membership> memberships) {
        this.memberships = memberships;
    }*/

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public enum State {
        ON, OFF
    }
}

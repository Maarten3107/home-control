package be.mmidia.light.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.joda.time.DateTime;

@Entity
public class Group {
    @Id
    private String id;

    private DateTime creationDate;

    //@OneToMany(mappedBy = "group")
    //private Set<Membership> memberships;
    //private Map<String, Light> members;


    // TODO: Necessary?
    public Group(String id) {
        this.id = id;
        //this.memberships = new HashSet<>();
        this.creationDate = DateTime.now();
    }

    public String getId() {
        return id;
    }

    public DateTime getCreationDate() {
        return creationDate;
    }

    /*public Set<Membership> getMemberships() {
        return memberships;
    }*/

    /*public Set<Membership> addMember(final String lightId){
        memberships.add(new Membership(lightId, ))
    }*/

    /*public Map<String, Light> getMembers() {
        return members;
    }

    public Map<String, Light> addMember(Light light) {
        if(null != light && !members.containsKey(light.getId())) {
            members.put(light.getId(), light);
        }
        return members;
    }

    public Map<String, Light> removeMember(Light light) {
        if(light != null) {
            removeMember(light.getId());
        }
        return members;
    }

    public Map<String, Light> removeMember(final String lightId) {
        if(lightId != null && members.containsKey(lightId)) {
            members.remove(lightId);
        }
        return members;
    }*/
}

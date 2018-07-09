package be.mmidia.light.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Profile {
    @Id
    private String id;
    //private List<LightSetting> lightSettings;
    //private List<GroupSetting> groupSettings;

    public Profile(String id) {
        this.id = id;
    }

    /*public class LightSetting {
        private String id;
        private String lightId;
        private Light.State state;
    }

    public class GroupSetting {
        private String id;
        private String groupId;
        private Light.State state;
    }*/
}

package be.mmidia.light.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

//@Entity
@Getter
@Setter
public class Profile implements Serializable {
    @Id
    private String id;
    //private List<LightSetting> lightSettings;
    //private List<GroupSetting> groupSettings;

    /*public Profile(String id) {
        this.id = id;
    }*/

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

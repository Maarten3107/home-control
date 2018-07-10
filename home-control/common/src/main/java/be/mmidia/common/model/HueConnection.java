package be.mmidia.common.model;

import java.util.UUID;
/*import javax.persistence.Entity;
import javax.persistence.Id;*/
import org.joda.time.DateTime;

//@Entity
public class HueConnection {
    //@Id
    private UUID id;
    private String username;
    private String lastConnectedIP;
    private DateTime connectionStarted;

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastConnectedIP() {
        return lastConnectedIP;
    }

    public void setLastConnectedIP(String lastConnectedIP) {
        this.lastConnectedIP = lastConnectedIP;
    }

    public DateTime getConnectionStarted() {
        return connectionStarted;
    }

    public void setConnectionStarted(DateTime connectionStarted) {
        this.connectionStarted = connectionStarted;
    }
}

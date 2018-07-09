package be.mmidia.light.model;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HueConnection {
    @Id
    private UUID id;
    private String username;
    private String lastConnectedIP;

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
}

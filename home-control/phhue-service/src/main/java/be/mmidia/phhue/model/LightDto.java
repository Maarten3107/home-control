package be.mmidia.phhue.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

@Getter
@Setter
@Builder
public class LightDto {
    private long id; /// ???

    private State state;
    private SwUpdate swUpdate;
    private String type;
    private String name;
    private String modelId;
    private String manufacturerName;
    private String productName;
    private Capabilities capabalities;
    private Config config;
    private String uniqueId;
    private String swVersion;

    @Setter
    @Getter
    @Builder
    public class SwUpdate {
        private String state;
        private DateTime lastInstall;
    }

    @Setter
    @Getter
    @Builder
    public class Config {
        private String archetype;
        private String function;
        private String direction;
    }
}

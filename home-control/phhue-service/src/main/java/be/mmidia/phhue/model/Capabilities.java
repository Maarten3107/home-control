package be.mmidia.phhue.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Capabilities {
    private boolean certified;
    private Control control;
    private Streaming streaming;

    @Setter
    @Getter
    @Builder
    public class Control {
        private int mindimLevel;
        private int maxLumen;
        private String colorGamutType;
        private double[][] colorGamut;
        private Ct ct;

        @Setter
        @Getter
        @Builder
        public class Ct {
            private int min;
            private int max;
        }
    }

    @Setter
    @Getter
    @Builder
    public class Streaming {
        private boolean renderer;
        private boolean proxy;
    }
}

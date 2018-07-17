package be.mmidia.phhue.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class State {
    private boolean on;
    private int bri;
    private int hue;
    private int sat;
    private String effect;
    private double[] xy; // 2
    private int ct;
    private String alert;
    private String colormode;
    private String mode;
    private boolean reachable;
}

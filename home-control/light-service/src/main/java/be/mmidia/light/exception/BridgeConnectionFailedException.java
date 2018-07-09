package be.mmidia.light.exception;

public class BridgeConnectionFailedException extends Exception {
    public BridgeConnectionFailedException() {
    }

    public BridgeConnectionFailedException(final int code, final String message) {
        super(code + ": " + message);
    }
}

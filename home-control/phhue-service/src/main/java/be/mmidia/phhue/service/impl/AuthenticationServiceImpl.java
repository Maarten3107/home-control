package be.mmidia.phhue.service.impl;

import be.mmidia.phhue.config.RemoteConfigProperties;
import be.mmidia.phhue.service.AuthenticationService;

public class AuthenticationServiceImpl implements AuthenticationService {
    // https://api.meethue.com/oauth2/auth?clientid=<clientid>&appid=<appid>&deviceid=<deviceid>&devicename=<devicename>&state=<state>&response_type=code
    private RemoteConfigProperties remoteConfigProperties;

    public AuthenticationServiceImpl(RemoteConfigProperties remoteConfigProperties) {
        this.remoteConfigProperties = remoteConfigProperties;
    }

    public void authenticate() {

    }
}
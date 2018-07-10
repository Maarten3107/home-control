package be.mmidia.phhue.service.impl;

// import be.mmidia.light.dao.HueConnectionDao;
import be.mmidia.common.model.HueConnection;
import be.mmidia.phhue.service.HueService;
import com.philips.lighting.hue.sdk.PHAccessPoint;
import com.philips.lighting.hue.sdk.PHHueSDK;
import com.philips.lighting.hue.sdk.PHMessageType;
import com.philips.lighting.hue.sdk.PHSDKListener;
import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHHueError;
import com.philips.lighting.model.PHHueParsingError;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class HueServiceImpl implements HueService {
    private static final Logger LOGGER = LoggerFactory.getLogger(HueServiceImpl.class);

    private PHHueSDK phHueSDK;
    private PHAccessPoint accessPoint;

    private HueConnection hueConnection;

    /*@Autowired
    private HueConnectionDao hueConnectionDao;*/

    public PHAccessPoint getBridgeConnection(){
        if(accessPoint == null){
            phHueSDK = PHHueSDK.create();
            phHueSDK.setAppName("HomeController");
            phHueSDK.getNotificationManager().registerSDKListener(listener);
        }

        return accessPoint;
    }

    public boolean connectToLastKnownAccessPoint(final String username) {
        /*String username = HueProperties.getUsername();
        String lastIpAddress =  HueProperties.getLastConnectedIP();*/

        /*if (username==null || lastIpAddress == null) {
            desktopView.showDialog("Missing Last Username or Last IP.  Last known connection not found.");
            return false;
        }*/

//        HueConnection lastConnection = hueConnectionDao.fetchLastConnectionForUsername(username);
//
//        PHAccessPoint accessPoint = new PHAccessPoint();
//        accessPoint.setIpAddress(lastConnection.getLastConnectedIP());
//        accessPoint.setUsername(username);
//        phHueSDK.connect(accessPoint);
        return true;
    }

    private PHSDKListener listener = new PHSDKListener() {

        @Override
        public void onAccessPointsFound(List<PHAccessPoint> accessPointsList) {
            /*desktopView.getFindingBridgeProgressBar().setVisible(false);
            AccessPointList accessPointList = new AccessPointList(accessPointsList, instance);
            accessPointList.setVisible(true);
            accessPointList.setLocationRelativeTo(null);*/  // Centre the AccessPointList Frame
        }

        @Override
        public void onAuthenticationRequired(PHAccessPoint accessPoint) {
            // Start the Pushlink Authentication.
            //desktopView.getFindingBridgeProgressBar().setVisible(false);
            phHueSDK.startPushlinkAuthentication(accessPoint);

            /*pushLinkDialog = new PushLinkFrame(instance);
            pushLinkDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            pushLinkDialog.setModal(true);
            pushLinkDialog.setLocationRelativeTo(null); // Center the dialog.
            pushLinkDialog.setVisible(true);*/

        }

        @Override
        public void onBridgeConnected(PHBridge bridge, String username) {
            phHueSDK.setSelectedBridge(bridge);
            phHueSDK.enableHeartbeat(bridge, PHHueSDK.HB_INTERVAL);
            //desktopView.getFindingBridgeProgressBar().setVisible(false);

            String lastIpAddress =  bridge.getResourceCache().getBridgeConfiguration().getIpAddress();
            hueConnection = new HueConnection();
            hueConnection.setUsername(username);
            hueConnection.setLastConnectedIP(lastIpAddress);
//            hueConnectionDao.createConnection(hueConnection);

            /*HueProperties.storeUsername(username);
            HueProperties.storeLastIPAddress(lastIpAddress);
            HueProperties.saveProperties();*/

            // Update the GUI.
            /*desktopView.getLastConnectedIP().setText(lastIpAddress);
            desktopView.getLastUserName().setText(username);*/

            // Close the PushLink dialog (if it is showing).
            /*if (pushLinkDialog!=null && pushLinkDialog.isShowing()) {
                pushLinkDialog.setVisible(false);
            }*/

            // Enable the Buttons/Controls to change the hue bulbs.s
            /*desktopView.getRandomLightsButton().setEnabled(true);
            desktopView.getSetLightsButton().setEnabled(true);*/

        }

        @Override
        public void onCacheUpdated(List<Integer> arg0, PHBridge arg1) {
        }

        @Override
        public void onConnectionLost(PHAccessPoint arg0) {
        }

        @Override
        public void onConnectionResumed(PHBridge arg0) {
        }

        @Override
        public void onError(int code, final String message) {

            /*throw new BridgeConnectionFailedException(code, message);*/

            if (code == PHHueError.BRIDGE_NOT_RESPONDING) {
                /*desktopView.getFindingBridgeProgressBar().setVisible(false);
                desktopView.getFindBridgesButton().setEnabled(true);
                desktopView.getConnectToLastBridgeButton().setEnabled(true);
                desktopView.showDialog(message);*/
            }
            else if (code == PHMessageType.PUSHLINK_BUTTON_NOT_PRESSED) {
                /*pushLinkDialog.incrementProgress();*/
            }
            else if (code == PHMessageType.PUSHLINK_AUTHENTICATION_FAILED) {
                /*if (pushLinkDialog.isShowing()) {
                    pushLinkDialog.setVisible(false);
                    desktopView.showDialog(message);
                }
                else {
                    desktopView.showDialog(message);
                }
                desktopView.getFindBridgesButton().setEnabled(true);*/
            }
            else if (code == PHMessageType.BRIDGE_NOT_FOUND) {
                /*desktopView.getFindingBridgeProgressBar().setVisible(false);
                desktopView.getFindBridgesButton().setEnabled(true);
                desktopView.showDialog(message);*/
            }
        }

        @Override
        public void onParsingErrors(List<PHHueParsingError> parsingErrorsList) {
            for (PHHueParsingError parsingError: parsingErrorsList) {
                System.out.println("ParsingError : " + parsingError.getMessage());
            }
        }
    };

}

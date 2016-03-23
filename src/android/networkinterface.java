package com.albahra.plugin.networkinterface;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class networkinterface extends CordovaPlugin {
	public static final String GET_IP_ADDRESS="getIPAddress";

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		try {
			if (GET_IP_ADDRESS.equals(action)) {
				JSONArray ips = new JSONArray();
				String ip;

                getIPs(ips);

                callbackContext.success(ips);
                return true;
			}
			callbackContext.error("Error no such method '" + action + "'");
			return false;
		} catch(Exception e) {
			callbackContext.error("Error while retrieving the IP address. " + e.getMessage());
			return false;
		}
	}

    private static JSONObject prepareResult(String ip, String adapter) throws JSONException {
        JSONObject obj = new JSONObject();

        obj.put("ip", ip);
        obj.put("adapter", adapter);

        return obj;
    }

	private void getIPs(JSONArray ips) {
		try {
			for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
				NetworkInterface intf = (NetworkInterface) en.nextElement();
                if (intf.isUp() && !intf.isLoopback()) {
                    for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                        InetAddress inetAddress = enumIpAddr.nextElement();

                        if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                            String ipaddress = inetAddress.getHostAddress();

                            ips.put(prepareResult(ipaddress, intf.getName()));
                        }
                    }
                }
			}
		} catch (JSONException ex) {
			Log.e(GET_IP_ADDRESS, "Exception in Get IP Address: " + ex.toString());
		} catch (SocketException ex) {
			Log.e(GET_IP_ADDRESS, "Exception in Get IP Address: " + ex.toString());
		}
	}
}

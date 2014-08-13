/**
 * 
 */
package com.product.autotourapp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * @author quoc.lehn
 *
 */
public class NetworkUtils {
	public static boolean isNetworkAvailable(Context context) {
		
		try {
			boolean HaveConnectedWifi = false;
			boolean HaveConnectedMobile = false;
			ConnectivityManager cm = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo[] netInfo = cm.getAllNetworkInfo();
			for (NetworkInfo ni : netInfo) {
				if (ni.getTypeName().equalsIgnoreCase("WIFI"))
					if (ni.isConnected()) {
						System.out.println("wifi");
						HaveConnectedWifi = true;
					}
				if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
					if (ni.isConnected()) {
						System.out.println("mobile");
						HaveConnectedMobile = true;
					}
			}
			return HaveConnectedWifi || HaveConnectedMobile;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
}

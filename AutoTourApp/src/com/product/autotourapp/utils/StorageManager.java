package com.product.autotourapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class StorageManager {
	
	public static final String PREFS_NAME = "locationdetected";
	public static final String k_INTERVAL_LISTEN_SECOND = "intervalListeningSecond";
	public static final String k_USERNAME_MK = "UsernameMockup";
	public static final String k_KEY_MK = "KeyMockup";
	public static final String k_LISTEN_ENABLE = "listenEnable";
	public static final String k_SETTING_PASS = "SettingPass";
	public static final String k_LAT = "latitude";
    public static final String k_LNG = "longitude";

	public static void saveCacheIntervalSecond(Context context, int number) {
		SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
	      SharedPreferences.Editor editor = settings.edit();
	      editor.putInt(k_INTERVAL_LISTEN_SECOND, number);
	      editor.commit();
	}
	
	public static int loadCacheIntevalSecond(Context context) {
		SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
	    return settings.getInt(k_INTERVAL_LISTEN_SECOND, 60);
	}
	
	
	public static void saveUsernameCached(Context context, String username){
		SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putString(k_USERNAME_MK, username);
		editor.commit();
	}
	
	public static String loadUsernameCached(Context context){
		SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
		return settings.getString(k_USERNAME_MK, "test6");
	}
	
	public static void saveSettingPassCached(Context context, String username){
		SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putString(k_SETTING_PASS, username);
		editor.commit();
	}
	
	public static String loadSettingPassCache(Context context){
		SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
		return settings.getString(k_SETTING_PASS, "123456");
	}
	
	public static void saveLatitudeCached(Context context, String username){
		SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putString(k_LAT, username);
		editor.commit();
	}
	
	public static String loadLatitudeCache(Context context){
		SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
		return settings.getString(k_LAT, "10.7853923");
	}
	
	public static void saveLongitudeCached(Context context, String username){
		SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
	      SharedPreferences.Editor editor = settings.edit();
	      editor.putString(k_LNG, username);
	      editor.commit();
	}
	
	public static String loadLongitudeCache(Context context){
		SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
	    return settings.getString(k_LNG, "106.659721");
	}
	
	public static void saveLastLoctCached(Context context, String key){
		SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putString(k_LNG, key);
		editor.commit();
	}
	
	public static void saveKeyCached(Context context, String key){
		SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
	      SharedPreferences.Editor editor = settings.edit();
	      editor.putString(k_KEY_MK, key);
	      editor.commit();
	}
	
	public static String loadKeyCached(Context context){
		SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
	    return settings.getString(k_KEY_MK, "BGGVB2KM0Z0WV0TW");
	}
	
	public static void saveListenEnable(Context context, boolean isEnable) {
		SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
	    SharedPreferences.Editor editor = settings.edit();
	    editor.putBoolean(k_LISTEN_ENABLE, isEnable);
	    editor.commit();
	}
	
	public static boolean getListenEnableStatus(Context context) {
		SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
	    return settings.getBoolean(k_LISTEN_ENABLE, false);
	}
}

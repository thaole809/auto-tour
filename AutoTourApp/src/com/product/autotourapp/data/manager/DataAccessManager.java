package com.product.autotourapp.data.manager;

import android.content.Context;

import com.product.autotourapp.utils.StorageManager;

public class DataAccessManager {
	private static DataAccessManager instance;
	private Context context;
	
	public static void init(Context context) {
		instance = new DataAccessManager(context);
	}
	
	public static DataAccessManager getInstance(){
		return instance;
	}
	
	public DataAccessManager(Context context) {
		this.context = context;
	}
	
	public String getUsername() {
		return StorageManager.loadUsernameCached(context);
	}
	
	public String getKey(){
		return StorageManager.loadKeyCached(context);
	}
	
	public String getLatitude(){
		return StorageManager.loadLatitudeCache(context);
	}
	
	public String getLongitude(){
		return StorageManager.loadLongitudeCache(context);
	}
	
}

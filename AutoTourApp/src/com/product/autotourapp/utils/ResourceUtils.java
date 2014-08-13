package com.product.autotourapp.utils;

import android.content.Context;

public class ResourceUtils {
	private static ResourceUtils instance;
	private Context context;
	public static void init(Context context) {
		instance = new ResourceUtils(context);
	}
	
	public static ResourceUtils getInstance() {
		return instance;
	}
	
	private ResourceUtils(Context context) {
		this.context = context;
	}
	
	public String getResourceText(int stringId) {
		return context.getResources().getText(stringId).toString();
	}
	
	public float getResourceDimen(int dimenId) {
		return context.getResources().getDimension(dimenId);
	}
	
	
}

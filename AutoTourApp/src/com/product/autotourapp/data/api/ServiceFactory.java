package com.product.autotourapp.data.api;

import android.content.Context;

import com.product.autotourapp.data.api.ServiceConstant.ServiceType;

public class ServiceFactory {
	
	private static ServiceFactory instance;
	public static ServiceFactory getInstance() {
		if (instance == null) {
			instance = new ServiceFactory();
		}
		return instance;
	}
	
//	private SendLocationServiceSetting sendLocationServiceSetting;
//	private LoginServiceSetting loginServiceSetting;
//	private AddLocationServiceSetting addLocationServiceSetting;
//	private AddRevenueServiceSetting addRevenueServiceSetting;
	
	public ServiceFactory() {
//		sendLocationServiceSetting = new SendLocationServiceSetting();
//		loginServiceSetting = new LoginServiceSetting();
//		addLocationServiceSetting = new AddLocationServiceSetting();
//		addRevenueServiceSetting = new AddRevenueServiceSetting();
	}
	
	public BaseRFService makeService(Context context, ServiceType type) {
		BaseRFService service = null;
//		switch (type) {
//		case SEND_LOCATION:
//			service = new BaseRFService(context, sendLocationServiceSetting); 
//			break;
//
//		case SEND_LOGIN:
//			service = new BaseRFService(context, loginServiceSetting); 
//			break;
//
//		case ADD_LOCATION:
//			service = new BaseRFService(context, addLocationServiceSetting); 
//			break;
//
//		case ADD_REVENUE:
//			service = new BaseRFService(context, addRevenueServiceSetting); 
//			break;
//			
//		default:
//			break;
//		}
		return service;
	}
}
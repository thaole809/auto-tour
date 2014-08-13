package com.product.autotourapp.data.api;


public class ServiceConstant {
	public static final int SERVICE_TIMEOUT = 60000;	
	public static final int SOCKET_TIMEOUT = 60000;	
	public static String SEVICE_DOMAIN = "http://smadmin.vinass.com";
	
	public enum MethodType {
		POST, GET, UPLOAD,
	}
	
	public enum ServiceType{
		SEND_LOCATION
		,SEND_LOGIN
		,ADD_LOCATION
		,ADD_REVENUE
	}
	
	public final static String URL_SEND_LOCATION= "/locations/send";
	public final static String URL_LOGIN= "/users/login";
	public final static String URL_ADD_LOCATION= "/locations/add";
	public final static String URL_ADD_REVENUE= "/revenues/add";
	
}

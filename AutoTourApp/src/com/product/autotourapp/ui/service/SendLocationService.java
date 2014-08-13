package com.product.autotourapp.ui.service;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.os.IBinder;
import android.util.Log;

import com.product.autotourapp.data.api.BaseRFService;
import com.product.autotourapp.data.api.BaseRFService.IServiceDelegate;
import com.product.autotourapp.data.api.ServiceConstant.ServiceType;
import com.product.autotourapp.data.api.ServiceFactory;
import com.product.autotourapp.data.api.sendlocation.SendLocationParamJSM;
import com.product.autotourapp.data.model.PlaceResultModel;
import com.product.autotourapp.utils.StorageManager;


public class SendLocationService extends Service {
	
//	private GooglePlayTracker googlePlayTracker;
//	private Timer mTimer;
	@Override
	public void onCreate() {
//		googlePlayTracker = new GooglePlayTracker(getApplicationContext(), new IGooglePlayTrackerDelegate() {
//			@Override
//			public void onGotLocation(Location location) {
//				Log.d("debug", "======== pushLocationToServer");
//				pushLocationToServer(location);
//				StorageManager.saveLatitudeCached(getApplicationContext(), location.getLatitude() + "");
//				StorageManager.saveLongitudeCached(getApplicationContext(), location.getLongitude() + "");
//			}
//		});
//		googlePlayTracker.connect();
	}
	
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
//		googlePlayTracker.startListener(StorageManager.loadCacheIntevalSecond(getApplicationContext()) * 1000);
	    return Service.START_STICKY;
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d("debug", "======== disconnect service");
//		googlePlayTracker.disconnect();
	}
	
	
	private void pushLocationToServer(Location location) {
//		PlaceResultModel model = new PlaceResultModel();
//		model.latitude = location.getLatitude();
//		model.longitude = location.getLongitude();
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.US);
//		model.dateTimeString = sdf.format(new Date());
//		callPushLocationService(model);
	}
	
	private void callPushLocationService(PlaceResultModel model){
		BaseRFService service = ServiceFactory.getInstance().makeService(this, ServiceType.SEND_LOCATION);
		SendLocationParamJSM paramJSM = new SendLocationParamJSM();
		String mockupKey = StorageManager.loadKeyCached(getApplicationContext());
		if (mockupKey != "123456") {
			paramJSM.key = StorageManager.loadKeyCached(getApplicationContext());
		}
		paramJSM.username = StorageManager.loadUsernameCached(getApplicationContext());
		paramJSM.locations = model.latitude + ";" + model.longitude + ";" + model.dateTimeString;
		
		service.setJSMParams(paramJSM);
		service.sendRequest(new IServiceDelegate() {
			
			@Override
			public void handleSuccess(String strResult) {
			}
			
			@Override
			public void handleError(String errorMsg) {
			}
		});
	}
}

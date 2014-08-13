package com.product.autotourapp.data.api;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.product.autotourapp.data.parser.JacksonManager;
import com.product.autotourapp.utils.NetworkUtils;




public class BaseRFService{
	public interface IServiceDelegate {
		public void handleSuccess(String strResult);
		public void handleError(String errorMsg);
	}
	final static int STATE_SUCCESS = 0;
	final static int STATE_ERROR = 1;
	
	private Context context;
	private BaseJSONModel params;
	private String strResult;
	private String errorMesage;
	private IServiceDelegate delegate;
	private ResultHandler resultHandler;
	private HttpClient httpclient;
	private HttpResponse httpResponse;
	private ServiceSetting setting;
	private boolean isCallSuccess;
	
	public BaseRFService(Context context, ServiceSetting setting) {
		this.context = context;
		this.setting = setting;
		this.params = null;
	}
	
	public void setJSMParams(BaseJSONModel params) {
		this.params = params;
	}
	
	public void sendRequest(IServiceDelegate delegate) {
		isCallSuccess = false;
		errorMesage = "Error";
		
		resultHandler = new ResultHandler();
		HttpParams params = new BasicHttpParams(); 
	    HttpConnectionParams.setConnectionTimeout(params, ServiceConstant.SERVICE_TIMEOUT);
	    HttpConnectionParams.setSoTimeout(params, ServiceConstant.SOCKET_TIMEOUT);
	    httpclient = new DefaultHttpClient(params);
	    httpResponse = null;
	    this.delegate = delegate;
	    
		Thread serviceThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				switch (setting.getMethodType()) {
				case GET:
//					sendGetRequest();
					sendGetRequestWithLoop(10);
					break;
				case POST:
//					sendPostRequest();
					sendPostRequestWithLoop(10);
					break;
				case UPLOAD:
					sendUploadRequest();
					break;
				default:
					break;
				}
			    if (isCallSuccess && httpResponse != null) {
					try {
						strResult = EntityUtils.toString(httpResponse.getEntity());
						resultHandler.sendEmptyMessage(STATE_SUCCESS);
					} catch (ParseException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					resultHandler.sendEmptyMessage(STATE_ERROR);
				}
			}
		});
		
		if (!NetworkUtils.isNetworkAvailable(context)) {
			if (delegate != null) {
				errorMesage = "No network connection!";
				resultHandler.sendEmptyMessage(STATE_ERROR);
			}
		} else { 
			serviceThread.start();
		}
	}
	
	private void sendPostRequestWithLoop(int loopNumber) {
		int count = 0;
		while (count < loopNumber) {
			count++;
			if (sendPostRequest()) {
				break;
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private boolean sendPostRequest() {
		try 
		{
			String urlService = setting.getServiceUrl();
		    HttpPost httpPost = new HttpPost(urlService);
			if (params != null) {
				String paramsString = JacksonManager.getJsonString(params, false);
				JSONObject jsonObject = new JSONObject(paramsString);
			    Iterator keys = jsonObject.keys();
			    ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
			    while (keys.hasNext()) {
			    	String key = (String) keys.next();
			    	String value = jsonObject.getString(key);
			    	if (value != null && value.length() > 0 && !value.equalsIgnoreCase("null")) {
			    		params.add(new BasicNameValuePair(key, value));
					}
			    }
			    
				httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
				httpResponse = httpclient.execute(httpPost);
				isCallSuccess = true;
				return true;
			}
			
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	private void sendUploadRequest() {
		
	}
	
	private void sendGetRequestWithLoop(int loopNumber) {
		int count = 0;
		while (count < loopNumber) {
			count++;
			if (sendGetRequest()) {
				break;
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	private boolean sendGetRequest() {
		HttpGet httpGet;
		try {
			String urlService = setting.getServiceUrl();
			if (params != null) {
				StringBuilder sb = new StringBuilder(urlService);
				String paramsString = JacksonManager.getJsonString(params, false);
				sb.append("?");
			    JSONObject jsonObject = new JSONObject(paramsString);
			    Iterator keys = jsonObject.keys();
			    while (keys.hasNext()) {
			    	String key = (String) keys.next();
			    	String value = jsonObject.getString(key);
			    	if (value != null && value.length() > 0 && !value.equalsIgnoreCase("null")) {
			    		sb.append(key);
			    		sb.append("=");
			    		sb.append(value);
			    		sb.append("&");
					}
			    }
			    urlService = sb.toString();
			}
			httpGet = new HttpGet(new URI(urlService));
			httpResponse = httpclient.execute(httpGet);
			isCallSuccess = true;
			return true;
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private class ResultHandler extends Handler {
		@Override
		public void handleMessage(Message msg) {
			if (msg.what == STATE_SUCCESS) {
				if (delegate!= null) {
					delegate.handleSuccess(strResult);
				}
			} else if (msg.what == STATE_ERROR) {
				if (delegate!= null) {
					delegate.handleError(errorMesage);
				}
			}
		}
	}
}

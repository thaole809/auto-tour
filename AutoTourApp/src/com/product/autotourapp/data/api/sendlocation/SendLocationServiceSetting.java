package com.product.autotourapp.data.api.sendlocation;

import com.product.autotourapp.data.api.ServiceConstant;
import com.product.autotourapp.data.api.ServiceConstant.MethodType;
import com.product.autotourapp.data.api.ServiceSetting;

public class SendLocationServiceSetting implements ServiceSetting{

	@Override
	public String getServiceUrl() {
		return ServiceConstant.SEVICE_DOMAIN + ServiceConstant.URL_SEND_LOCATION;
	}

	@Override
	public MethodType getMethodType() {
		return MethodType.POST;
	}

}

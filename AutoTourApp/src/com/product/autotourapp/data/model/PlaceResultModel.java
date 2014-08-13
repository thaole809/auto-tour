package com.product.autotourapp.data.model;



public class PlaceResultModel {
	
	public enum ResultType{
		GET_NOW,
		LISTEN,
	}
	
	public String dateTimeString;
	public double latitude;
	public double longitude;
	public ResultType type;
}

package com.product.autotourapp.data.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;



public class JacksonManager {
	
	private static ObjectMapper jsonMapper = null;
	
	
	/**
	 * parse from a JSON String
	 * @param jsonData
	 * @param clazz
	 * @return
	 */
	public static <T> T parseJson(String jsonData, Class<T> clazz) {
		T result = null;
		try {
			result = getJsonMapper().readValue(jsonData, clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Get JSON String from a JSON structure
	 * @param object
	 * @param isFormatOutput
	 * @return
	 */
	
	public static String getJsonString(Object object, boolean isFormatOutput){
		String jsonString = "";
		try {
			if (isFormatOutput) {
				jsonString = getJsonMapper().writerWithDefaultPrettyPrinter(  ).writeValueAsString( object );
			}
			else  jsonString = getJsonMapper().writeValueAsString( object );
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonString;
	}
	
	
	private static ObjectMapper getJsonMapper(){
		if (null == jsonMapper) {
			jsonMapper = new ObjectMapper();
			jsonMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
			jsonMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		}
		return jsonMapper;
	}
	
	public static String fixTGUDJsonFormat(String result) {
		StringBuilder sBuilder = new StringBuilder(result);
		sBuilder.insert(0, "{\"data\":");
		sBuilder.append("}");
		return sBuilder.toString();
	}
}

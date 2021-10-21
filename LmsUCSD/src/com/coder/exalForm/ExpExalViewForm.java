package com.coder.exalForm;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections4.map.HashedMap;

public class ExpExalViewForm {
private HttpServletRequest request;
private HttpServletResponse response;
private String exalTypeId;
private String title;
private String path;
private Map<String,String> mapExalTypes=new HashedMap<String,String>();
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public Map<String, String> getMapExalTypes() {
	return mapExalTypes;
}
public void setMapExalTypes(Map<String, String> mapExalTypes) {
	this.mapExalTypes = mapExalTypes;
}
public String getExalTypeId() {
	return exalTypeId;
}
public void setExalTypeId(String exalTypeId) {
	this.exalTypeId = exalTypeId;
}
public HttpServletRequest getRequest() {
	return request;
}
public void setRequest(HttpServletRequest request) {
	this.request = request;
}
public HttpServletResponse getResponse() {
	return response;
}
public void setResponse(HttpServletResponse response) {
	this.response = response;
}
public String getPath() {
	return path;
}
public void setPath(String path) {
	this.path = path;
}
}

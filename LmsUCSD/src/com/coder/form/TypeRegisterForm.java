package com.coder.form;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

import com.coder.model.Type;

public class TypeRegisterForm {
private String bookGroupId;
private TypeForm typeForm=null;
private List<Type> types;
private List<TypeForm> typeForms;
private Map<String,String> mapBookGroups=new HashedMap<String,String>();
private Map<String,String> mapTypes=new HashedMap<String,String>();
public TypeForm getTypeForm() {
	return typeForm;
}
public void setTypeForm(TypeForm typeForm) {
	this.typeForm = typeForm;
}
public Map<String, String> getMapBookGroups() {
	return mapBookGroups;
}
public void setMapBookGroups(Map<String, String> mapBookGroups) {
	this.mapBookGroups = mapBookGroups;
}
public Map<String, String> getMapTypes() {
	return mapTypes;
}
public void setMapTypes(Map<String, String> mapTypes) {
	this.mapTypes = mapTypes;
}
public List<Type> getTypes() {
	return types;
}
public String getBookGroupId() {
	return bookGroupId;
}
public void setBookGroupId(String bookGroupId) {
	this.bookGroupId = bookGroupId;
}
public void setTypes(List<Type> types) {
	this.types = types;
}
public List<TypeForm> getTypeForms() {
	return typeForms;
}
public void setTypeForms(List<TypeForm> typeForms) {
	this.typeForms = typeForms;
}

}

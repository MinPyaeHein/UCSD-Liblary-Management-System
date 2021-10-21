package com.coder.util;

import com.coder.form.TeacherForm;
import com.coder.form.TeacherRegisterForm;

import javassist.bytecode.stackmap.BasicBlock.Catch;

public class PrjSubFunction {
	public static Integer convertId(String strId,String type){
		int id=-1;
		try{
	
		if(type.equals("SID")){
			System.out.println("SID="+strId);
			 id=Integer.parseInt(strId.substring(4,strId.length()));	
		}else if(type.equals("TID")){
			 id=Integer.parseInt(strId.substring(4,strId.length()));	
		}else if(type.equals("ID")){
			 id=Integer.parseInt(strId.substring(3,strId.length()));	
		}
		else if(type.equals("BID")){
			 id=Integer.parseInt(strId.substring(4,strId.length()));	
		}
	
	}catch(Exception e){
	id=-1;	
	}
		return id;
		}
	public static boolean teacherRegTest(TeacherRegisterForm teacherRegisterForm){
		TeacherForm teacherForm=teacherRegisterForm.getTeacherForm();
		String teacherName=teacherForm.getTeacherName();
		String address=teacherForm.getAddress();
		String pass=teacherForm.getPassword();
		String phone=teacherForm.getPhone();
		if(address==null||pass==null||phone==null||teacherName==null){
			return false;
		}
		if(address.equals("")||pass.equals("")||phone.equals("")||teacherName.equals("")){
			return false;
		}
		return true;
	}
		}

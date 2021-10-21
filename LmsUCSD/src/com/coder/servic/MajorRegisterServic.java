package com.coder.servic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.dao.MajorDao;
import com.coder.form.MajorForm;
import com.coder.form.MajorRegisterForm;
import com.coder.model.Major;
@Service
@Repository("majorRegisterService")
public class MajorRegisterServic {
	@Autowired
	private MajorDao majorDao;
	
	
	public void prepareMajorRegister(MajorRegisterForm majorRegisterForm){
		MajorForm majorForm=majorRegisterForm.getMajorForm();
		if(majorForm!=null){
			
			this.majorRegister(majorRegisterForm);
			majorForm=null;
		  }
	    majorRegisterForm.setMajorForm(majorForm);
		List<Major> majors=this.majorDao.getMajors();
		majorRegisterForm.setMajors(majors);
     
      
	
	}
	private int majorRegister(MajorRegisterForm majorRegisterForm){
		Major major=new Major();
		
		MajorForm majorForm=majorRegisterForm.getMajorForm();
		major.setMajorName(majorForm.getMajorName());
		major.setShortTerm(majorForm.getShortTerm());
		int id=this.majorDao.saveMajor(major);
		
		
	return id; 
	}

}

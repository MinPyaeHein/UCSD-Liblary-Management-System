package com.coder.servic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.dao.AcademicYearDao;
import com.coder.dao.MajorDao;
import com.coder.form.AcademicYearForm;
import com.coder.form.AcademicYearRegisterForm;
import com.coder.form.MajorForm;
import com.coder.form.MajorRegisterForm;
import com.coder.model.AcademicYear;
import com.coder.model.Major;
import com.coder.util.DateFormat;
@Service
@Repository("academicYearRegisterServic")
public class AcademicYearRegisterServic {
	@Autowired
	private AcademicYearDao academicYearDao;
	
	
	public void prepareAcademicYearRegister(AcademicYearRegisterForm academicYearRegisterForm){
		AcademicYearForm academicYearForm=academicYearRegisterForm.getAcademicYearForm();
		if(academicYearForm!=null){
			this.academicYearRegister(academicYearRegisterForm);
			academicYearForm=null;
		  }
		academicYearRegisterForm.setAcademicYearForm(academicYearForm);
		List<AcademicYear> academicYears=this.academicYearDao.getAcademicYears();
		academicYearRegisterForm.setAcademicYears(academicYears);
     
      
	
	}
	private int academicYearRegister(AcademicYearRegisterForm academicYearRegisterForm){
		AcademicYear academicYear=new AcademicYear();
		
		AcademicYearForm academicYearForm=academicYearRegisterForm.getAcademicYearForm();
		academicYear.setStartYear(DateFormat.stringToDateFormat_dd_mm_yyyy(academicYearForm.getStartYear()));
		academicYear.setEndYear(DateFormat.stringToDateFormat_dd_mm_yyyy(academicYearForm.getEndYear()));
		int id=this.academicYearDao.saveAcademicYear(academicYear);
		
		
	return id; 
	}

}

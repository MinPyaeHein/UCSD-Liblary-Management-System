package com.coder.dao;





import java.util.List;

import org.springframework.stereotype.Repository;

import com.coder.model.AcademicYear;
import com.coder.model.Book;
import com.coder.model.BookGroup;
import com.coder.model.Shell;
import com.coder.model.Type;





@Repository("academicYearDao")
public class AcademicYearDao extends AbstractDao<Integer,AcademicYear>{
	
	public Integer saveAcademicYear(AcademicYear academicYear)
	{
	return (Integer)super.persist(academicYear);

		}
	public AcademicYear getAcademicYearpById(int id){
		AcademicYear academicYear=super.criteriaQuerryGetObjectById(id,"yearId");
		return academicYear;
		}
  
public void  updateAcademicYear(AcademicYear academicYear)
{
super.update(academicYear);

}

public List<AcademicYear> getAcademicYears() {
	List<AcademicYear> academicYears=(List<AcademicYear>)super.getAllEntity();
		return academicYears;
	}

}

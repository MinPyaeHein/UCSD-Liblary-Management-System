package com.coder.servic;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.user.UserRegistryMessageHandler;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.dao.AcademicYearDao;
import com.coder.dao.AdminDao;
import com.coder.dao.BookAvailableDao;
import com.coder.dao.BookDao;
import com.coder.dao.BookEditionDao;
import com.coder.dao.DepartmentDao;
import com.coder.dao.GreadDao;
import com.coder.dao.MajorDao;
import com.coder.dao.MemberDao;
import com.coder.dao.PositionDao;
import com.coder.dao.RoleDao;
import com.coder.dao.ShellDao;
import com.coder.dao.StudentDao;
import com.coder.dao.TeacherDao;
import com.coder.form.AdminForm;
import com.coder.form.AdminRegisterform;
import com.coder.form.BookAvailableForm;
import com.coder.form.BookAvailableRegisterForm;
import com.coder.form.BookForm;
import com.coder.form.BookRegisterForm;
import com.coder.form.LoginForm;
import com.coder.form.MemberForm;
import com.coder.form.StudentForm;
import com.coder.form.StudentRegisterForm;
import com.coder.form.TeacherForm;
import com.coder.form.TeacherRegisterForm;
import com.coder.model.AcademicYear;
import com.coder.model.Admin;
import com.coder.model.Book;
import com.coder.model.BookAvailable;
import com.coder.model.BookEdition;
import com.coder.model.Department;
import com.coder.model.Gread;
import com.coder.model.Major;
import com.coder.model.Member;
import com.coder.model.Position;
import com.coder.model.Role;
import com.coder.model.Shell;
import com.coder.model.Student;
import com.coder.model.Teacher;
import com.coder.util.DateFormat;
@Service
@Repository("bookAvailableServic")
public class BookAvailableServic {
	
	@Autowired
	private BookAvailableDao bookAvailableDao;
	
	
	public int prepareBookAvailableRegister(BookAvailableRegisterForm bookAvailableRegisterForm){
		BookAvailableForm bookAvailableForm=bookAvailableRegisterForm.getBookAvailableForm();
		BookAvailable bookAvailable=new BookAvailable();
		bookAvailable.setBookId(Integer.parseInt(bookAvailableForm.getBookId()));
		bookAvailable.setUserId(bookAvailableForm.getUserId());
		bookAvailable.setSent(Integer.parseInt(bookAvailableForm.getSent()));
	    int id=this.bookAvailableDao.saveBookAvailable(bookAvailable);
	    return id;
	}

}

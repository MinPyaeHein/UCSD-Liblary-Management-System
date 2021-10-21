package com.coder.servic;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.user.UserRegistryMessageHandler;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.coder.dao.AcademicYearDao;
import com.coder.dao.BookDao;
import com.coder.dao.BookEditionDao;
import com.coder.dao.DepartmentDao;
import com.coder.dao.GreadDao;
import com.coder.dao.MajorDao;
import com.coder.dao.MemberDao;
import com.coder.dao.PositionDao;
import com.coder.dao.ShellDao;
import com.coder.dao.StudentDao;
import com.coder.dao.TeacherDao;
import com.coder.form.BookForm;
import com.coder.form.BookRegisterForm;
import com.coder.form.LoginForm;
import com.coder.form.MemberForm;
import com.coder.form.StudentForm;
import com.coder.form.StudentRegisterForm;
import com.coder.form.TeacherForm;
import com.coder.form.TeacherRegisterForm;
import com.coder.model.AcademicYear;
import com.coder.model.Book;
import com.coder.model.BookEdition;
import com.coder.model.Department;
import com.coder.model.Gread;
import com.coder.model.Major;
import com.coder.model.Member;
import com.coder.model.Position;
import com.coder.model.RentReturnStudent;
import com.coder.model.RentReturnTeacher;
import com.coder.model.Shell;
import com.coder.model.Student;
import com.coder.model.Teacher;
import com.coder.util.DateFormat;
import com.coder.util.FileUpload;
import com.coder.util.PrjSubFunction;
import com.coder.util.ServerPath;
@Service
@Repository("teacherService")
public class TeacherServic {
	@Autowired
	private DepartmentDao departmentDao;
	@Autowired
	private PositionDao positionDao;
	@Autowired
	private TeacherDao teacherDao;
	@Autowired
	private AcademicYearDao academicYearDao;
	@Autowired
	private LoginServic loginServic;
	@Autowired
	private MemberDao memberDao;

	public void prepareTeacherRegister(TeacherRegisterForm teacherRegisterForm){
		TeacherForm teacherForm=teacherRegisterForm.getTeacherForm();
		if(teacherForm!=null){
			int id=teacherRegister(teacherRegisterForm);
		}
	teacherForm=new TeacherForm();
	String newId="";
	Teacher teacher=this.teacherDao.getLatestTeacherId();
	if(teacher==null){
		newId="TID-"+1;
	}else{
		newId="TID-"+(teacher.getTeacherId()+1);
	}
	    System.out.println("newId="+newId);
		teacherForm.setTeacherId(newId);
		List<Position> positions=this.positionDao.getPositions();
		List<Department> departments=this.departmentDao.getDepartments();
		List<AcademicYear> academicYears=this.academicYearDao.getAcademicYears();
	   
	    teacherRegisterForm.setTeacherForm(teacherForm);
		for(Position pos:positions){
			teacherRegisterForm.getMapPositions().put(pos.getPositionId()+"",pos.getPositionName());
		}
		for(Department dep:departments){
			teacherRegisterForm.getMapDepartments().put(dep.getDepartmentId()+"",dep.getDepartmentName());
		}
		for(AcademicYear ac:academicYears){
			teacherRegisterForm.getMapAcademicYears().put(""+ac.getYearId(),DateFormat.dateToString_YYYY(ac.getStartYear())+"-"+DateFormat.dateToString_YYYY(ac.getEndYear()));
		}
		List<Member> members=this.memberDao.getMembers();
		for(Member me:members){
			teacherRegisterForm.getMapMembers().put(""+me.getMemberId(),me.getMemberName());
		}
		
	}
	private int teacherRegister(TeacherRegisterForm teacherRegisterForm){
		Teacher teacher=new Teacher();
		TeacherForm teacherForm=teacherRegisterForm.getTeacherForm();
		teacher.setTeacherName(teacherForm.getTeacherName());
		teacher.setPhone(teacherForm.getPhone());
		teacher.setEmail(teacherForm.getEmail());
		teacher.setAddress(teacherForm.getAddress());
		teacher.setAddress1(teacherForm.getAddress1());
		teacher.setGender(teacherForm.getGender());
		teacher.setCreateDate(new Date());
		AcademicYear academicYear=new AcademicYear();
		Position position=new Position();
		Department department=new Department();
		Member member=new Member();
		member.setMemberId(Integer.parseInt(teacherForm.getMemberId()));
		academicYear.setYearId(Integer.parseInt(teacherForm.getYearId()));
		position.setPositionId(Integer.parseInt(teacherForm.getPositionId()));
		department.setDepartmentId(Integer.parseInt(teacherForm.getDepartmentId()));
		teacher.setMember(member);
		teacher.setAcademicYear(academicYear);
		teacher.setPosition(position);
		teacher.setDepartment(department);
		int id=teacherDao.saveTeacher(teacher);
		 String serverPath=ServerPath.getPath();
		  String adminPath=ServerPath.createFloder(serverPath+File.separator+"teacher");
		  for (MultipartFile multipartFile :teacherForm.getImageFiles()) {
        
        	String fileName=id+"";

        		String url=adminPath+File.separator+fileName+".jpg";
        	
        		FileUpload.uploadFile(multipartFile,url);
        		
        		break;
           
        }
		LoginForm loginForm=new LoginForm();
		loginForm.setPassword(teacherForm.getPassword());
		loginForm.setUserId(teacherForm.getTeacherId());
		loginForm.setUserName(teacherForm.getTeacherName());
		loginServic.LoginRegister(loginForm);
		
		return id; 
	}
	public void showAllTeacher(TeacherRegisterForm teacherRegisterForm){
		List<Teacher> teachers=this.teacherDao.getTeachers();
		teacherRegisterForm.setTeachers(teachers);
	}
	public void showTeacherDetail(TeacherRegisterForm teacherRegisterForm){
		int id=PrjSubFunction.convertId(teacherRegisterForm.getTeacherId(),"SID");
		Teacher teacher=this.teacherDao.getTeacherById(id);
		teacherRegisterForm.setTeacher(teacher);
	}
	public void showRentTeacher(TeacherRegisterForm teacherRegisterForm){
		int id=PrjSubFunction.convertId(teacherRegisterForm.getTeacherId(),"SID");
		Teacher teacher=this.teacherDao.getTeacherById(id);
		Set<RentReturnTeacher> rentReturnTeacherSets=teacher.getRentReturnTeachers();
		List<RentReturnTeacher> rentReturnTeachers=new ArrayList<RentReturnTeacher>();
		for(RentReturnTeacher rentReturnTeacher:rentReturnTeacherSets){
			if("9999-09-09".equals(""+rentReturnTeacher.getReturnDate())){
				rentReturnTeacher.setReturnDate(null);
				rentReturnTeachers.add(rentReturnTeacher);
			}
		}
		
		teacherRegisterForm.setRentReturnTeachers(rentReturnTeachers);
	}
	public void showReturnStudent(TeacherRegisterForm teacherRegisterForm){
		int id=PrjSubFunction.convertId(teacherRegisterForm.getTeacherId(),"SID");
		Teacher teacher=this.teacherDao.getTeacherById(id);
		Set<RentReturnTeacher> rentReturnTeacherSets=teacher.getRentReturnTeachers();
		List<RentReturnTeacher> rentReturnTeachers=new ArrayList<RentReturnTeacher>();
		for(RentReturnTeacher rentReturnTeacher:rentReturnTeacherSets){
			if(!"9999-09-09".equals(""+rentReturnTeacher.getReturnDate())){
				rentReturnTeachers.add(rentReturnTeacher);
			}
		}
		
		teacherRegisterForm.setRentReturnTeachers(rentReturnTeachers);
	}
}

package com.coder.servic;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.user.UserRegistryMessageHandler;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.coder.dao.AcademicYearDao;
import com.coder.dao.AdminDao;
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
import com.coder.util.FileUpload;
import com.coder.util.ServerPath;
@Service
@Repository("adminService")
public class AdminServic {
	
	@Autowired
	private PositionDao positionDao;
	@Autowired
	private AdminDao adminDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private LoginServic loginServic;
	public void prepareAdminRegister(AdminRegisterform adminRegisterform){
		AdminForm teacherForm=adminRegisterform.getAdminForm();
		if(teacherForm!=null){
			int id=adminRegister(adminRegisterform);
		}
	teacherForm=new AdminForm();
	String newId="";
	Admin admin=this.adminDao.getLatestAdminId();
	if(admin==null){
		newId="ID-"+1;
	}else{
		newId="ID-"+(admin.getAdminId()+1);
	}
	    System.out.println("newId="+newId);
		teacherForm.setAdminId(newId);
		List<Position> positions=this.positionDao.getPositions();
		List<Role> roles=this.roleDao.getRoles();
		
		
		adminRegisterform.setAdminForm(teacherForm);
		for(Role r:roles){
			adminRegisterform.getMapRoles().put(r.getRoleId()+"",r.getRoleName());
   		}
		for(Position pos:positions){
			adminRegisterform.getMapPositions().put(pos.getPositionId()+"",pos.getPositionName());
		}
	}
	private int adminRegister(AdminRegisterform adminRegisterform){
		Admin admin=new Admin();
		AdminForm adminForm=adminRegisterform.getAdminForm();
		admin.setAdminName(adminForm.getAdminName());
		admin.setEmail(adminForm.getEmail());
		admin.setNrc(adminForm.getNrc());
		admin.setPhone(adminForm.getPhone());
		admin.setAddress(adminForm.getAddress());
		admin.setAddress1(adminForm.getAddress1());
		Role role=new Role();
		Position position=new Position();
		role.setRoleId(Integer.parseInt(adminForm.getRoleId()));
		position.setPositionId(Integer.parseInt(adminForm.getPositionId()));
		admin.setPosition(position);
		admin.setRole(role);
		int id=this.adminDao.saveAdmin(admin);
		 String serverPath=ServerPath.getPath();
		  String adminPath=ServerPath.createFloder(serverPath+File.separator+"admin");
		  for (MultipartFile multipartFile :adminForm.getImageFiles()) {
      
        	String fileName=id+"";

      		String url=adminPath+File.separator+fileName+".jpg";
      	
      		FileUpload.uploadFile(multipartFile,url);
      		
      		break;
         
      }
		LoginForm loginForm=new LoginForm();
		loginForm.setPassword(adminForm.getPassword());
		loginForm.setUserId(adminForm.getAdminId());
		loginForm.setUserName(adminForm.getAdminName());
		loginServic.LoginRegister(loginForm);
		
		return id; 
	}
	public void showAllAdmin(AdminRegisterform adminRegisterform){
    List<Admin> admins=this.adminDao.getAdmins();
	adminRegisterform.setAdmins(admins);
	}
	

}

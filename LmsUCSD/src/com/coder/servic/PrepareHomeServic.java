package com.coder.servic;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.user.UserRegistryMessageHandler;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.coder.dao.LoginDao;
import com.coder.dao.PrepareHomeDao;
import com.coder.form.LoginForm;
import com.coder.form.PrepareHomeForm;
import com.coder.model.Login;


@Service
@Repository("prepareHomeServic")
public class PrepareHomeServic {
	@Autowired
	private PrepareHomeDao prepareHomeDao;
		public void prepareHome(PrepareHomeForm prepareHomeForm){
	     prepareHomeForm.setBookTotal(prepareHomeDao.getAllBooksQty()+"");
	     int rentTotal=prepareHomeDao.getAllRentStuQty()+prepareHomeDao.getAllRentTeaQty();
	     prepareHomeForm.setRentTotal(rentTotal+"");
	     int userTotal=prepareHomeDao.getAllStuQty()+prepareHomeDao.getAllTeaQty();
	     prepareHomeForm.setUserTotal(userTotal+"");
	     prepareHomeForm.setGroupTotal(prepareHomeDao.getAllBookGroupQty()+"");
		
		
		
	}
	
}

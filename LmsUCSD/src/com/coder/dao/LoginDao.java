package com.coder.dao;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.coder.model.Login;
@Repository("loginDao")
public class LoginDao extends AbstractDao<Integer,Login>{
	
	public void saveLogin(Login login)
	{
	super.persistVoid(login);
    }
	
	public Login getLoginById(int id){
		Login login=super.criteriaQuerryGetObjectById(id,"teacherId");
	return login;}
  
    public void  updateLogin(Login login)
    {
    super.update(login);
    }
    public void  deleteLogin(Login login)
    {
    super.delete(login);
    }
    public Login getLoginByUserIdAndPassword(String userId,String password) {
		Login login=super.getObjectTwoParam(userId.trim(),"userId",password.trim(),"password");
		return login;
	}
    public List<Login> getLogins() {
	List<Login> logins=(List<Login>)super.getAllEntity();
		return logins;
	}

}

package com.coder.dao;

import java.util.List;

import org.springframework.stereotype.Repository;


import com.coder.model.Shell;
import com.coder.model.Type;


@Repository("shellDoa")
public class ShellDao extends AbstractDao<Integer,Shell>{
	
	public Integer saveShell(Shell shell)
	{
	return (Integer)super.persist(shell);

		}
	
	public List<Shell> getShells() {
		List<Shell> shells=(List<Shell>)super.getAllEntity();
			return shells;
		}
	public Shell getShellById(int id){
		Shell shell=super.criteriaQuerryGetObjectById(id,"shellId");
		return shell;
		}




}

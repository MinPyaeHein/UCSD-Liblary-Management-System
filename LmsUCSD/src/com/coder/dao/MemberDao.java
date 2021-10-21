package com.coder.dao;
import java.util.List;

import org.springframework.stereotype.Repository;


import com.coder.model.Book;
import com.coder.model.Member;
import com.coder.model.Student;
import com.coder.model.Teacher;
@Repository("memberDoa")
public class MemberDao extends AbstractDao<Integer,Member>{
	
	public Integer saveMember(Member member)
	{
	return (Integer)super.persist(member);
	}
	public Member getMemberById(int id){
		Member student=super.criteriaQuerryGetObjectById(id,"memberId");
		return student;
	}
  
public void  updateMember(Member member)
{
super.update(member);
}
public void  deleteMember(Member member)
{
super.delete(member);
}
public List<Member> getMembers() {
List<Member> members=(List<Member>)super.getAllEntity();
	return members;
}



}

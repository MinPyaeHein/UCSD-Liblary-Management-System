package com.coder.form;

import java.util.List;

import com.coder.model.Member;

public class MemberRegisterForm {
private MemberForm memberForm=null;
private List<Member> members;
public MemberForm getMemberForm() {
	return memberForm;
}
public void setMemberForm(MemberForm memberForm) {
	this.memberForm = memberForm;
}
public List<Member> getMembers() {
	return members;
}
public void setMembers(List<Member> members) {
	this.members = members;
} 
}

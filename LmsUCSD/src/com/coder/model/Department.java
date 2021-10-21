package com.coder.model;
// Generated Aug 10, 2020 11:24:30 AM by Hibernate Tools 5.0.6.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Department generated by hbm2java
 */
@Entity
@Table(name = "department", catalog = "mmhbusin_lmstu")
public class Department implements java.io.Serializable {

	private Integer departmentId;
	private String departmentName;
	private String shortTerm;
	private Set<Teacher> teachers = new HashSet<Teacher>(0);

	public Department() {
	}

	public Department(String departmentName, String shortTerm) {
		this.departmentName = departmentName;
		this.shortTerm = shortTerm;
	}

	public Department(String departmentName, String shortTerm, Set<Teacher> teachers) {
		this.departmentName = departmentName;
		this.shortTerm = shortTerm;
		this.teachers = teachers;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "department_id", unique = true, nullable = false)
	public Integer getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	@Column(name = "department_name", nullable = false, length = 200)
	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Column(name = "short_term", nullable = false, length = 50)
	public String getShortTerm() {
		return this.shortTerm;
	}

	public void setShortTerm(String shortTerm) {
		this.shortTerm = shortTerm;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
	public Set<Teacher> getTeachers() {
		return this.teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

}

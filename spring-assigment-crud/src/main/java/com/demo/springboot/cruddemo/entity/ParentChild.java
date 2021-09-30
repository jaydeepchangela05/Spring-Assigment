package com.demo.springboot.cruddemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parent_children")
public class ParentChild {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "full_name")
	private String fullName;
	

	@Column(name = "children")
	private String children;
	
	public ParentChild() {
		
	}

	public ParentChild(int id, String name, int age, String fullName, String children) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.fullName = fullName;
		this.children = children;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getChildren() {
		return children;
	}

	public void setChildren(String children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "ParentChild [id=" + id + ", name=" + name + ", age=" + age + ", fullName=" + fullName + ", children="
				+ children + "]";
	}
	
}

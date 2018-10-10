package com.grade.entity;

/**
 * 班级
 * @author zjf
 */
public class Grade {
	
	private int id; // 主键自增
	private String name; // 班级名
	private String biz;  // 班级备注
	
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
	public String getBiz() {
		return biz;
	}
	public void setBiz(String biz) {
		this.biz = biz;
	}
	
	public Grade(int id, String name, String biz) {
		super();
		this.id = id;
		this.name = name;
		this.biz = biz;
	}
	public Grade() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Grade(String name, String biz) {
		super();
		this.name = name;
		this.biz = biz;
	}
}

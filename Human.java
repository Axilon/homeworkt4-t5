package main;
public class Human {
	private String name;
	private String surName;
	private int age;
	private String sex;
	
	public Human(String name, String surName, int age, String sex) {

		super();
		this.name = name;
		this.surName = surName;
		this.age = age;
		this.sex = sex;
	}
	public Human() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Name = " + name + "| SurName = " + surName + "| age = " + age + "| sex = " + sex;
	}
	
	
}

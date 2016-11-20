package main;
public class Student extends Human{
	private int progress;

	public Student(String name, String surName, int age, String sex, int progress) {
		super(name, surName, age, sex);
		this.progress = progress;
	}

	public Student() {
		super();
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	@Override
	public String toString() {
		return super.toString() +"| Progress=" + progress;
	}
	

}

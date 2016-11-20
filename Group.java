package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Group implements RecruitmentOffice {
	private String groupNumber = "12-ML";
	private Student[] studentArray = new Student[10];
		

	public Group(String groupNumber, Student[] studentArray) {
		super();
		this.groupNumber = groupNumber;
		this.studentArray = studentArray;
	}

	public Group() {
		super();
	}

	public String getGroupNumber() {
		return groupNumber;
	}

	public void setGroupNumber(String groupNumber) {
		this.groupNumber = groupNumber;
	}

	public Student[] getStudentArray() {
		return studentArray;
	}

	public void setStudentArray(Student[] studentArray) {
		this.studentArray = studentArray;
	}
	
	public void addStudent(Student student) {
		try {
			for (int i = 0; i < studentArray.length; i++) {

				if (studentArray[i] == null) {
					studentArray[i] = student;
					System.out.println(
							student.getSurName() + " " + student.getName() + " was added to " + groupNumber + " group");
					return;
				}
			}
			throw new StudentAddException();
		} catch (StudentAddException e) {
			e.toString();
		}

	}
	
	public void interativeAddStudent() {
		Scanner sc = new Scanner(System.in);
		
		
		try{	
			System.out.println("Please enter the name");
			String name = sc.nextLine();
			System.out.println("Please enter the Sur-name");
			String surName = sc.nextLine();
			System.out.println("Please enter sex");
			String sex =sc.nextLine();
			System.out.println("Please int the age");
			int age=sc.nextInt();
			System.out.println("Please int the progress");
			int progress = sc.nextInt();
		Student iS = new Student(name,surName,age,sex,progress);
		addStudent(iS);
		}catch(NullPointerException e){
			System.out.println(e);
			System.out.println(e.getCause());
		}
		sc.close();
		
}

	public void deleteStudentBySurName(String surName) {
		for (int i = 0; i < studentArray.length; i++) {
			if (studentArray[i].getSurName() == surName) {
				studentArray[i] = null;
				System.out.println(surName + " was deleted from the group " + groupNumber);
				return;
			}
			if (studentArray[i].getSurName() != surName && i == studentArray.length - 1) {
				System.out.println("Sorry, but we don`t find any student with surname - " + surName + " to delete");
				return;
			}
		}
	}

	public void findStudentBySurName(String surName) {
		for (int i = 0; i < studentArray.length; i++) {
			if (studentArray[i].getSurName() == surName) {
				System.out.println(studentArray[i].toString());
				return;
			}
			if (studentArray[i].getSurName() != surName && i == studentArray.length - 1) {
				System.out.println("Sorry, but we don`t find any student with surname - " + surName);
				return;
			}
		}
	}

	public static int compare(Student a, Student b) {
		if (a == null && b != null) {
			return 1;
		}
		if (a != null && b == null) {
			return -1;
		}
		if (a == null && b == null) {
			return 0;
		}
		return 11;

	}
	

	
		
	@Override
	public Student[] recList() {
		System.out.println();
		System.out.println("List of recruits:");
		int count = 0;
		for (int i = 0; i < studentArray.length; i++) {
			if (studentArray[i] != null && studentArray[i].getSex().equalsIgnoreCase("male")
					&& studentArray[i].getAge() >= 18) {
				count++;
			}
		}
		Student[] recList = new Student[count];
		int j = 0;
		for (int i = 0; i < studentArray.length; i++) {
			if (studentArray[i] != null && studentArray[i].getSex().equalsIgnoreCase("male")
					&& studentArray[i].getAge() >= 18) {
				recList[j] = studentArray[i];
				j++;
			}
		}
		for (Student student : recList) {
			// if(student == null)continue;
			System.out.println(student);
		}
		return recList;

	}
	
	public void saveGroup() {
		for (int i = 0; i <studentArray.length; i++) {
			if(studentArray[i] == null){
				throw new IllegalArgumentException("Null pointer cat");
			}
			try(PrintWriter pw = new PrintWriter("Group.txt")){
				pw.println(studentArray[i].toString());
			}catch(IOException e){
				System.out.println("Save Error");
			}
		}
	}

	public void loadGroup() {
		try (BufferedReader br = new BufferedReader(new FileReader("Group.txt"))) {
			String text = br.readLine();
			System.out.println(text);

		} catch (IOException e) {
			System.out.println("File not found");
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(groupNumber + " Group list:");
		sb.append(System.lineSeparator());

		for (int i = 0; i < studentArray.length; i++) {
			sb.append((i + 1) + ". ");
			if (studentArray[i] == null) {
				sb.append("free ");

			}
			if (studentArray[i] != null) {
				Arrays.sort(studentArray,
						(a, b) -> compare(a, b) != 11 ? compare(a, b) : a.getSurName().compareTo(b.getSurName()));
				sb.append(
						studentArray[i].getSurName() + " ; " + studentArray[i].getName() + " ; " + studentArray[i].getAge()
								+ " ; " + studentArray[i].getSex() + " ; " + studentArray[i].getProgress());
			}

			sb.append(System.lineSeparator());
		}
		return sb.toString();
	}
	
}

	
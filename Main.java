package main;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Student[] studentArray = new Student[11];
		Group group = new Group();
		group.addStudent( studentArray[0]=new Student("Pavel", "Struchkov", 21, "male", 12));
		group.addStudent( studentArray[1] = new Student("Oleg", "Olegov", 45, "male", 19));
		group.addStudent(studentArray[2] = new Student("Aleksey", "Stenkov", 12, "male", 12));
		group.addStudent(studentArray[3] = new Student("Olga", "Molochka", 18, "Female", 7));
		group.addStudent(studentArray[4] = new Student("Mariya", "Oduvanchik", 25, "Female", 12));
		group.addStudent(studentArray[5] = new Student("Sveta", "Strucha", 29, "Female", 12));
		group.addStudent(studentArray[6] = new Student("Svetik", "Semizvetik", 21, "Female", 6));
		group.addStudent(studentArray[7] = new Student("Artur", "Pirozhkov", 20, "male", 9));
		group.addStudent(studentArray[8] = new Student("Dun`ka", "Vuvorka", 15, "Female", 10));
		group.addStudent(studentArray[9] = new Student("Andriian", "Sukhanov", 24, "male", 12));
		
		RecruitmentOffice ro = group;
		ro.recList();
		
		
		System.out.println();
		System.out.println(group.toString());
//		System.out.println();
		group.addStudent(studentArray[10] = new Student("Andrey", "Shahbazyan", 13, "Ukranian", 15));
		System.out.println();
		group.deleteStudentBySurName("Semizvetik");
		group.findStudentBySurName("Olegov");
		
		group.deleteStudentBySurName("Olegov");
		System.out.println();
		System.out.println(group.toString());
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the parametr(Name/Surname/age/sex/progress) by wich you want to sort the group");
		String sr = sc.nextLine();
		groupSort(sr,group);
		sc.close();

		
		
	}

	public static void groupSort(String sr, Group group) {
		try {
			if (sr.equalsIgnoreCase("Name")) {
				Arrays.sort(group.getStudentArray(), (a, b) -> compareToByParemetr(a, b) != 11 ? compareToByParemetr(a, b) : a.getName().compareTo(b.getName()));
			}if (sr.equalsIgnoreCase("surName")) {
				Arrays.sort(group.getStudentArray(), (a, b) -> compareToByParemetr(a, b) != 11 ? compareToByParemetr(a, b) : a.getSurName().compareTo(b.getSurName()));
			}if (sr.equalsIgnoreCase("age")) {
				Arrays.sort(group.getStudentArray(), (a, b) -> compareToByParemetr(a, b) != 11 ? compareToByParemetr(a, b) : a.getAge() - b.getAge());
			}if (sr.equalsIgnoreCase("Sex")) {
				Arrays.sort(group.getStudentArray(), (a, b) -> compareToByParemetr(a, b) != 11 ? compareToByParemetr(a, b) : a.getSex().compareTo(b.getSex()));
			}if (sr.equalsIgnoreCase("progress")) {
				Arrays.sort(group.getStudentArray(), (a, b) -> compareToByParemetr(a, b) != 11 ? compareToByParemetr(a, b) : a.getProgress() - b.getProgress());
			}if (!(sr.equalsIgnoreCase("name") || sr.equalsIgnoreCase("surname") || sr.equalsIgnoreCase("age")
					|| sr.equalsIgnoreCase("sex") || sr.equalsIgnoreCase("progress"))) {
				System.out.println("Sorry, but there is no such parametr");
				return;
			}
			for (Student studentSort : group.getStudentArray()) {
				if(studentSort==null)continue;
				System.out.println(studentSort);
			}
			return;

		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
	}

	public static int compareToByParemetr(Student a, Student b) {
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

}

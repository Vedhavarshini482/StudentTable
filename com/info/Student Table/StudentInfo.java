import java.util.ArrayList;
import java.util.Scanner;

class Student {
	private int rollNo;
	private String name;
	private int age;

	public void setData(int rollNo, String name, int age) {
		this.rollNo = rollNo;
		this.name = name;
		this.age = age;
	}

	public int getrollNo() {
		return rollNo;
	}

	public String getname() {
		return name;
	}

	public int getage() {
		return age;
	}
}

class Details {
	private ArrayList<Student> studentList = new ArrayList<Student>();

	public void add(Student student) {
		studentList.add(student);
	}

	public void update(Student student, int number) {
		studentList.set(number - 1, student);
	}

	public void delete(int rollNo) {
		studentList.set(rollNo - 1, null);
	}

	public void viewAll() {
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i) != null) {
				Student temp = studentList.get(i);
				System.out.print(temp.getrollNo() + " ");
				System.out.print(temp.getname() + " ");
				System.out.println(temp.getage() + " ");
			}
		}
	}

	public void viewByRollNo(int rollNo) {
		Student temp = studentList.get(rollNo - 1);
		System.out.print(temp.getrollNo() + " ");
		System.out.print(temp.getname() + " ");
		System.out.println(temp.getage() + " ");
	}
}

public class StudentInfo {
	public static int strength;

	public static void main(String[] args) {
		StudentInfo info = new StudentInfo();
		info.studentInfo();
	}

	public void studentInfo() {
		Scanner scanner = new Scanner(System.in);
		Details details = new Details();
		System.out.println("Enter the Students Strength");
		strength = scanner.nextInt();
		Student student = new Student();
		for (int i = 0; i < strength; i++) {
			student = new Student();
			System.out.println("Enter the Student Roll number,Name and Age");
			student.setData(scanner.nextInt(), scanner.next(),
					scanner.nextInt());
			details.add(student);
		}
		details.viewAll();
		System.out
				.println("Enter the student roll number for that student details ");
		details.viewByRollNo(scanner.nextInt());
		System.out
				.println("Enter the student roll number for update that student details");
		int number = scanner.nextInt();
		System.out.println("Enter that Student Name and Age");
		Student studentUpdate = new Student();
		studentUpdate.setData(number, scanner.next(), scanner.nextInt());
		details.update(studentUpdate, number);
		System.out.println("Enter which student's details to be delete");
		details.delete(scanner.nextInt());
		details.viewAll();
	}
}
package com.tut;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Query;

public class View {
	static Scanner scanner = new Scanner(System.in);
	static EntityManagerFactory factory = Persistence.createEntityManagerFactory("Student");
	static EntityManager manager = factory.createEntityManager();
	static Controller controller = new Controller();

	public static Student getStudentObject() {

		Student student = new Student();
		System.out.println("Enter the Student name : ");
		scanner.nextLine();
		student.setNameString(scanner.nextLine());
		System.out.println("Enter the Student Address : ");
		student.setAddressString(scanner.nextLine());
		System.out.println("Enter the Student mobile number : ");
		student.setMobile(scanner.nextLong());
		System.out.println("Enter the Student Gender : ");
		scanner.nextLine();
		student.setGenderString(scanner.nextLine());
		return student;
	}

	public static int mainView() {
		System.out.println();
		System.out.println("Welcome to Student Portal");
		System.out.println("--------------------------");
		System.out.println(
				"Enter 1 for add student\nEnter 2 for Find student by Id\nEnter 3 for Update Student by ID\nEnter 4 for Delete Student by ID\nEnter 5 for find all Students\nEnter 6 for exit");
		int input = scanner.nextInt();
		System.out.println();
		return input;
	}

	public static boolean view_2(int input) {

		switch (input) {
		case 1:
			Student student = getStudentObject();
			manager.getTransaction().begin();
			manager.persist(student);
			manager.getTransaction().commit();
			System.out.println("Data Saved");
			break;
		case 2:
			System.out.println("Enter the Student ID : ");
			int inputFind = scanner.nextInt();
			Student studentFind = controller.findStudent(manager, inputFind);
			System.out.println(studentFind);
			break;
		case 3:
			System.out.println("Enter the Student ID : ");
			int inputUpdate = scanner.nextInt();
			Student studentUpdate = controller.updateStudent(manager, inputUpdate);
			System.out.println(
					"Enter 1 for update name\nEnter 2 for update address\nEnter 3 for update mobile number\nEnter 4 for update gender");
			int inputUpdateSwitch = scanner.nextInt();
			manager.getTransaction().begin();
			switch (inputUpdateSwitch) {
			case 1:
				System.out.println("Enter your name : ");
				scanner.nextLine();
				studentUpdate.setNameString(scanner.nextLine());
				System.out.println("Name updated");

				break;
			case 2:
				System.out.println("Enter your Address : ");
				scanner.nextLine();
				studentUpdate.setAddressString(scanner.nextLine());
				System.out.println("Address updated");

				break;
			case 3:
				System.out.println("Enter your Mobile Number : ");
				studentUpdate.setMobile(scanner.nextLong());
				System.out.println("Mobile Number updated");

				break;
			case 4:
				System.out.println("Enter your Gender : ");
				scanner.nextLine();
				studentUpdate.setGenderString(scanner.nextLine());
				System.out.println("Gender updated");

				break;
			default:
				System.out.println("Wrong input !!!!");
				break;
			}
			manager.persist(studentUpdate);
			manager.getTransaction().commit();
			break;
		case 4:
			System.out.println("Enter student ID : ");
			int inputDelete = scanner.nextInt();
			try {
				Student studentDelete = controller.deleteStudent(manager, inputDelete);
				manager.remove(studentDelete);
				System.out.println("Student details deleted");
				manager.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 5:
			System.out.println("Find All Student");
			
			List<Student> students = manager.createQuery("SELECT a FROM Student a").getResultList();
			for (Student st : students) {
				System.out.println(st);
				System.out.println();
			}
			break;
		case 6:
			System.out.println("Thank you !!!!!");
			return false;
		default:
			System.out.println("Wrong input enter again !!!!");
			break;
		}
		return true;
	}

	public static void main(String[] args) {
		Boolean flagBoolean = true;
		while (flagBoolean) {
			int input = mainView();
			flagBoolean = view_2(input);
		}
	}

}

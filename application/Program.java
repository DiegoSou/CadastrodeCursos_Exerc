package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

import entities.Course;
import entities.Student;
import entities.Teacher;

public class Program {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		
		try {
			System.out.print("Teacher's name: ");
			String tname = scan.next();
			
			Teacher t = new Teacher(tname);
			
			System.out.print("CSV FILE? (y/n) ");
			boolean fileSystem = scan.next().charAt(0) == 'y'? true : false;
			
//			Sistema que usa arquivos .csv já existentes no pc do usuário
			if (fileSystem) {
				System.out.print("Courses file path: ");
				String coursesPath = scan.next();
				
				try (BufferedReader bf = new BufferedReader(new FileReader(coursesPath))){
					String line = bf.readLine();
					
					while(line != null) {
						t.addCourse(line);
						line = bf.readLine();
					}
					System.out.println();
				}
				
				for(Course c : t.getCourses()) {
					System.out.print("Course " + c.getName() + " students file path: ");
					String studentsPath = scan.next();
					
					try (BufferedReader bf = new BufferedReader(new FileReader(studentsPath))){
						String line = bf.readLine();
						while(line != null) {
							c.addStudent(new Student(line));
							line = bf.readLine();
						}
					}

					System.out.println();
				}
				
//			Sistema que cria os arquivos .csv de acordo com o que o usuário digita
			}else {
				System.out.println("Set local path to create a files: ");
				String p = scan.next() + "\\documents";
				boolean sucess = new File(p).mkdir();
				System.out.println();
				
				if(sucess) {
					try (BufferedWriter bw = new BufferedWriter(new FileWriter(p + "\\courses.csv", true))){
						System.out.print("How many courses? ");
						int coursesQ = scan.nextInt();
						
						for(int i=1; i<=coursesQ; i++) {
							System.out.print("Course (name,price): ");
							String course = scan.next();
							
							t.addCourse(course);
							bw.write(course);
							bw.newLine();
						}
					}
					
					System.out.println();
					
					for(Course c : t.getCourses()) {
						System.out.print("How many students for course (" + c.getName() + ")? ");
						int a = scan.nextInt();
						
						for (int i=1; i<=a; i++) {
							try (BufferedWriter bw = new BufferedWriter(new FileWriter(p + "\\" + c.getName() + ".csv", true))){
								System.out.print("Student (name,code): ");
								String student = scan.next();
								c.addStudent(new Student(student));
								bw.write(student);
								bw.newLine();
							}
						}
						
						System.out.println();
					}
				}
			}

			
			System.out.println();
			System.out.println("Total Students: " + t.getStudents().size());
			System.out.println("Students: " + t.getStudents());
		}
		
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		scan.close();
	}

}

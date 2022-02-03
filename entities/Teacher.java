package entities;

import java.util.Set;
import java.util.TreeSet;

public class Teacher {
	
	private String name;
	private Set<Course> courses = new TreeSet<>();

	public Teacher(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void addCourse(String s) {
		String[] fields = s.split(",");
		courses.add(new Course(fields[0], Double.parseDouble(fields[1])));
	}
	
	public Set<Student> getStudents(){
		Set<Student> allStudents = new TreeSet<>();
		for (Course c : courses) {
			allStudents.addAll(c.getStudent());
		}
		
		return allStudents;
	}
}

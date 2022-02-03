package entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Course implements Comparable<Course>{
	
	private String name;
	private Double price;
	private Set<Student> students = new HashSet<>();
	
	public Course(String name) {
		this.name = name;
	}

	public Course(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Set<Student> getStudent() {
		return students;
	}

	public void addStudent(Student s) {
		students.add(s);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(name, other.name) && Objects.equals(price, other.price);
	}

	@Override
	public String toString() {
		return name + "," + price;
	}

	@Override
	public int compareTo(Course o) {
		return name.compareTo(o.getName());
	}
}

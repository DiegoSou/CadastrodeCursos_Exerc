package entities;

import java.util.Objects;

public class Student implements Comparable<Student>{
	
	private String name;
	private Integer codStudent;

	public Student(String s) {
		String[] fields = s.split(",");
		
		this.name = fields[0];
		this.codStudent = Integer.parseInt(fields[1]);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getCodStudent() {
		return codStudent;
	}

	public void setCodStudent(int codStudent) {
		this.codStudent = codStudent;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codStudent, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return codStudent == other.codStudent && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return name + "-" + codStudent;
	}

	@Override
	public int compareTo(Student o) {
		return codStudent.compareTo(o.getCodStudent());
	}
}

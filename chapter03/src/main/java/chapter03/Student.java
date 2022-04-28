package chapter03;

public class Student extends Person{
	private int grade;
	private String major;
	
	public Student() {
		//자식 생성자에 super 없으면 자동으로 super 가 들어감. 
		System.out.println("Student() called");
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
}

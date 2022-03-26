package basic;

import java.util.ArrayList;
import java.util.Vector;

class Student{
	private int sid;
	private String sname;
	private String courseName;
	private double tutionFee;
	
	public Student(int studentId,String studentName,String courseName,double tutionFees){
		this.setSid(studentId);;
		this.setSname(studentName);
		this.setCourseName(courseName);
		this.setTutionFee(tutionFees);
	}
	
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public double getTutionFee() {
		return tutionFee;
	}

	public void setTutionFee(double tutionFee) {
		this.tutionFee = tutionFee;
	}
	

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", courseName=" + courseName + ", tutionFee=" + tutionFee
				+ "]";
	}

//	public static void main(String[] args)  {
//		Student s1=new Student(1, "Snega", "JAVA", 6000.00);
//		Student s2=new Student(2, "Shivani","JAVA", 6000.00);
//		Student s3=new Student(3, "Karthi","JAVA", 6000.00);
//		ArrayList<Student> s=new ArrayList<Student>();
//		s.add(s1);
//		s.add(s2);
//		s.add(s3);
//		System.out.println(s);
//		for(Student p:s) {
//			System.out.println(p.sid+"  "+p.sname+"  "+p.getCourseName()+"  "+p.getTutionFee());
//		}
//	}
}

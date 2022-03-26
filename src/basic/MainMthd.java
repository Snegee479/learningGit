package basic;

import java.util.ArrayList;

public class MainMthd {
	public static void main(String[] args)  {
		Student s1=new Student(1, "Snega", "JAVA", 6000.00);
		Student s2=new Student(2, "Shivani","JAVA", 6000.00);
		Student s3=new Student(3, "Karthi","JAVA", 6000.00);
		ArrayList<Student> s=new ArrayList<Student>();
		s.add(s1);
		s.add(s2);
		s.add(s3);
		System.out.println(s);
		for(Student p:s) {
			System.out.println(p.getSid()+"  "+p.getSname()+"  "+p.getCourseName()+"  "+p.getTutionFee());
		}
	}
}

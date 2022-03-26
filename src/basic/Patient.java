package basic;

public class Patient {
	double computeBMI(double wt,double ht) {
		
		//BMI Calculation formula
		return wt/(ht*ht);
	}
	public static void main(String[] args) {
		Patient p1=new Patient();
		System.out.println("BMI of p1 is " + p1.computeBMI(59,1.7));
		Patient p2=new Patient();
		System.out.println(p2.computeBMI(59.4,1.4));
	}
}


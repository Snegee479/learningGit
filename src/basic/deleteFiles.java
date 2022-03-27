package basic;

	import java.io.File;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.Scanner;

	public class deleteFiles {
		public static void main(String[] args) throws IOException {
			String path="C:\\Users\\Welcome\\Documents\\Simplilearn\\";
			System.out.println("enter name of file that should be deleted");
			Scanner sc=new Scanner(System.in);
			String filedel=sc.next();
			String finalfile=path+filedel;
			File f=new File(finalfile);
			f.delete();
			}
	}
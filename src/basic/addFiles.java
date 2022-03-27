package basic;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class addFiles {
	public static void main(String[] args) throws IOException {
		String path="C:\\Users\\Welcome\\Documents\\Simplilearn\\";
		Scanner sc=new Scanner(System.in);
		ArrayList<String> al=new ArrayList<>();
		while(true) {
			System.out.println("enter the file name");
			String filename=sc.next();
			String finalfile=path+filename;
			File f=new File(finalfile);	
			boolean res=f.createNewFile();
			if(res==false) {
				System.out.println("file not created");
			}	
			else {
				al.add(filename);
				System.out.println("file is created");
			}
			System.out.println(al);
		}
	}
}



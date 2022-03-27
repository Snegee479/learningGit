package basic;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DisplayFiles {
	public static void main(String[] args) throws IOException {
		String path="C:\\Users\\Welcome\\Documents\\Simplilearn\\";
		Scanner sc=new Scanner(System.in);
		File f=new File(path);
		File filen[]=f.listFiles();
		for(File ff:filen) {
			System.out.println(ff);
		}
	}
}


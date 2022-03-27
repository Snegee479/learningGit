package basic;

	import java.io.File;
	import java.io.IOException;
	import java.util.Scanner;

	public class SearchFiles {
		public static void main(String[] args) throws IOException {
			String path="C:\\Users\\Welcome\\Documents\\Simplilearn\\";
			Scanner sc=new Scanner(System.in);
			File f=new File(path);
			System.out.println("enter the file name");
			String filesearch=sc.next();
			File filen[]=f.listFiles();
			int flag=0;
			for(File ff:filen) {
				if(ff.getName().equals(filesearch)) {
					flag=1;
					break;
				}
				else {
					flag=0;
				}
			}
			if(flag==1) {
				System.out.println("file is found");
			}
			else {
				System.out.println("file is not found");
			}			
		}
	}



package basic;

	import java.io.File;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.Scanner;

	public class phase1 {

		public static void main(String[] args) throws Exception {
			String path="C:\\Users\\Welcome\\Documents\\Simplilearn\\";
			String ApplicationName="LockedMe.com";
			String DeveloperName="Snega";
			System.out.println("Hi "+ DeveloperName + ", Welcome to "+ ApplicationName+" Project");
			Scanner sc=new Scanner(System.in);
			System.out.println("Please select and enter an option from below,");
			System.out.println("1. Display -->to display files in the directory");
			System.out.println("2. Add --> to add new files to the existing directory");
			System.out.println("3. Delete --> to delete an existing file");
			System.out.println("4. Search --> to fetch a file in the existing directory");
			System.out.println("5. Return --> to go back to main menu");
			String s=sc.next();
			
			if(s.equals("Display")) {
				File f=new File(path);
				File filen[]=f.listFiles();
				for(File ff:filen) {
					System.out.println(ff);
				}
			}
			else if(s.equals("Add")) {
				ArrayList<String> al=new ArrayList<>();
				while(true) {
					System.out.println("enter the file name");
					String filename=sc.next();
					String finalfile=path+filename;
					File f=new File(finalfile);	
					boolean res=f.createNewFile();
					if(res==false) {
						System.out.println("We  are not able to create the mentioned file. Please check if it is already exising or you are entering an appropriate format.");
					}	
					else {
						al.add(filename);
						System.out.println(filename);
						System.out.println("Congrats, you have created and added "+filename+" file");
					}
					System.out.println(al);
				}
			}
			else if(s.equals("Delete")) {
				System.out.println("Enter name of file that should be deleted");
				sc=new Scanner(System.in);
				String fileToDel=sc.next();
				String finalfile=path+fileToDel;
				File f=new File(finalfile);
				if(f.delete()) {
					System.out.println("Congrats, "+fileToDel+" has been deleted");
				}
				else {
					System.out.println("We couldn't delete the file. Please check the filename and if it is available in the directory.");
				}
			}
			else if(s.equals("Search")) {
				sc=new Scanner(System.in);
				File file=new File(path);
				System.out.println("enter the file name");
				String fileToFind=sc.next();
				File filearr[]=file.listFiles();
				int flag=0;
				for(File f:filearr) {
					if(f.getName().equals(fileToFind)) {
						flag=1;
						break;
					}
					else {
						flag=0;
					}
				}
				if(flag==1) {
					System.out.println(fileToFind+" File is found in your directory");
				}
				else {
					System.out.println(fileToFind+" File is not available in your directory");
				}			
			}
		}

	}

package Assessment;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class OopsProject {
	Scanner sc=new Scanner(System.in);
	private String path, ApplicationName, DeveloperName;
	public OopsProject(String path, String applicationName, String developerName) {
		this.path = path;
		ApplicationName = applicationName;
		DeveloperName = developerName;
		System.out.println("");
		System.out.println("Hi "+ DeveloperName + ", Welcome to "+ ApplicationName+" Project");
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getApplicationName() {
		return ApplicationName;
	}
	public void setApplicationName(String applicationName) {
		ApplicationName = applicationName;
	}
	public String getDeveloperName() {
		return DeveloperName;
	}
	public void setDeveloperName(String developerName) {
		DeveloperName = developerName;
	}
	void Display() {
		File file=new File(this.path);
		File FileArr[]=file.listFiles();
		for(int i=0;i<FileArr.length;i++) {
			String s=FileArr[i]+"";
			String ss[]=s.split("\\\\");
			int a=ss.length;
			int b=a-1;
			System.out.println(ss[b]);
		}
	}
	void Add() throws Exception {
		//by default it is case sensitive, to ignore it get input and covert it to either of the case, here am changing it to lower case before adding it
		ArrayList<String> al=new ArrayList<>();
		while(true) {
			System.out.println("Enter the file name to be added");
			String filename=sc.next().toLowerCase();
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
//		ignoring case sensitivity
//		ArrayList<String> al=new ArrayList<>();
//		while(true) {
//			System.out.println("Enter the file name to add");
//			String filename=sc.next();
//			File file=new File(this.path);
//			File filearr[]=file.listFiles();
//			int flag=0;
//			for(int i=0;i<filearr.length;i++) {
//				System.out.println(filearr[i]);
//				String s=filearr[i]+"";
//				String ss[]=s.split("\\\\");
//				System.out.println(ss[ss.length-1]+" is the array file name");
//				System.out.println(filename+" is the input filename");
//					if(ss[ss.length-1].equals(filename)) {
//						flag=1;
//					}
//					else {
//						flag=0;
//					}
//				}
//			System.out.println("Flag"+flag);
//
//			if(flag==1) {
//				System.out.println(filename+" file is already found in your directory");
//				System.out.println("We  are not able to create the mentioned file. Please check if it is already exising or you are entering an appropriate format.");
//				break;
//			}
//			else if(flag==0) {
//				String finalfile=path+filename;
//				File f=new File(finalfile);
//				System.out.println(f.createNewFile()+" creation");
//				al.add(filename);
//				System.out.println("Congrats, you have created and added "+filename+" file");
//			}
//			}			
		}
		
	void Delete() {
		//added case sensitivity by using equals()
		sc=new Scanner(System.in);
		System.out.println("Enter name of file that should be deleted");
		String fileToDel=sc.next();
		File file=new File(this.path);
		File filearr[]=file.listFiles();
		int flag=0;
		for(int i=0;i<filearr.length;i++) {
			//System.out.println(filearr[i]);
			String s=filearr[i]+"";
			String ss[]=s.split("\\\\");
			int a=ss.length;
			int b=a-1;
			//System.out.println(ss[b]+" is the array file name");
			//System.out.println(fileToDel+" is the input filename");
			if(ss[b].equals(fileToDel)) {
				//System.out.println("equal");
				flag=1;
				break;
			}
			else {
				flag=0;
			}
		}//System.out.println(flag+"flag");
		if(flag==1) {
			String finalFilePath=this.path+fileToDel;
			File ff=new File(finalFilePath);
			if(ff.delete()) {
				System.out.println("Congrats, "+fileToDel+" has been deleted");
			}
			else {
				System.out.println("We couldn't delete the file. Please check the filename and if it is available in the directory. And Note that we have made this function case senstive, so use accordingly.");
			}
		}
		else if(flag==0) {
			System.out.println("We couldn't delete the file. Please check the filename and if it is available in the directory. And Note that we have made this function case senstive, so use accordingly.");
		}
	}
	void Search() {
		//added case sensitivity by using equals()
		System.out.println("Enter the file name to search");
		sc=new Scanner(System.in);
		System.out.println("");
		File file=new File(path);
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
			System.out.println(fileToFind+" File is not available in your directory. And Note that we have made this function case senstive, so use accordingly.");
		}				
	}
	void mainMenu() throws Exception {
		System.out.println("Please select and enter an option from below,");
		System.out.println("1. Display -->to display files in the directory");
		System.out.println("2. Add --> to add new files to the existing directory");
		System.out.println("3. Delete --> to delete an existing file");
		System.out.println("4. Search --> to fetch a file in the existing directory");
		System.out.println("5. Return --> to go back to main menu");
		System.out.println("6. End --> to exit the build");
		Scanner sc=new Scanner(System.in);
		int option=sc.nextInt();
		switch (option) {
		  case 1:
		    System.out.println("---------------------------------------------------------------------");
			Display();
		    break;
		  case 2:
			System.out.println("---------------------------------------------------------------------");
			Add();
			break;
		  case 3:
			System.out.println("---------------------------------------------------------------------");
			Delete();
			break;
		  case 4:
			System.out.println("---------------------------------------------------------------------");
			Search();
			break;
		  case 5:
			System.out.println("---------------------------------------------------------------------");
			System.out.println("");
			System.out.println("Please select a valid option from below, to perform your required action");
			System.out.println("");
			mainMenu();
		    break;
		  case 6:
			System.out.println("Thanks for using our Application.");
		}

	}
	
	public static void main(String[] args) throws Exception {
		String path="C:\\Users\\Welcome\\Documents\\Simplilearn\\";
		String AppName="LockedMe.com";
		String DeveloperName="Snega";
		OopsProject o=new OopsProject(path,AppName,DeveloperName);
		System.out.println("");
		System.out.println("---------------------------------------------------------------------");
		System.out.println("");
		o.mainMenu();
	}

}

package basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileEx {
	public static void main(String[] args) throws IOException {
		String s="Snega Ranganathan is learning Java";
		//Byte
		FileOutputStream fos=new FileOutputStream("a.txt",true);
		byte b[]=s.getBytes();
		fos.write(b);
		System.out.println("data has been put into the file");
		FileInputStream fis=new FileInputStream("a.txt");
		int i=0;
		while((i=fis.read())!=-1)
		{//syso(i) will give the ascii values of all the chars
			System.out.print((char)i);
		}
		
		fos.close();
	//to copy the content of one file to another
//				FileOutputStream fos=new FileOutputStream("a.txt",true);
//				FileInputStream fis=new FileInputStream("snega.txt");
//				int i=0;
//				while((i=fis.read())!=-1)
//				{
//					fos.write(i);
//				}
//				
//				fos.close();
				
	}

}

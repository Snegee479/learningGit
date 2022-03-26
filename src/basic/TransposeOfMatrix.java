package basic;

import java.util.Arrays;
import java.util.Scanner;
//2-D-matrix
public class TransposeOfMatrix{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the row size");
		int row=sc.nextInt();
		System.out.println("enter the col size");
		int col=sc.nextInt();
		int a[][]=new int[row][col];
		System.out.println("the size of the array is "+a.length);
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				System.out.println("enter the "+i+","+j+"value");
				a[i][j]=sc.nextInt();
				
			}
		}
		//retriving 2 d array in matrix format
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				System.out.print(a[i][j]+"  ");
			}
			System.out.println();
		}
		
		
		//the transpose of the matrix is 
		System.out.println("the transpose of the matrix is");
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				System.out.print(a[j][i]+"  ");
			}
			System.out.println();
		}
		
	}
}

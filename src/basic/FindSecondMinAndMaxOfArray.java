package basic;

import java.util.Arrays;
import java.util.Scanner;

public class FindSecondMinAndMaxOfArray {
//input might be an unsorted array
		public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter size of array needed");
			int sizeOfArray=sc.nextInt();
			int arr[]=new int [sizeOfArray];
			//to get inputs in run time for evr element of array
			for(int i=0;i<arr.length;i++) {
				System.out.println("enter a value for "+i+"th element/index");
				arr[i]=sc.nextInt();
			}
			//to print every element of array via for each loop
			for(int arrTemp:arr) {
				System.out.println(arrTemp);
			}
			//to sort the array (by default it will sort in ascending order)
			Arrays.sort(arr);
			System.out.println("After sorting");
			for(int arrTemp:arr) {
				System.out.println(arrTemp);
			}
			System.out.println("enter value of n where you need the nth min and max value of array");
			int n=sc.nextInt();
			//to print the nth min and max value of array
			System.out.println("nt min and max values are "+arr[n-1]+", "+arr[arr.length-n]+" respectively");
		}
}

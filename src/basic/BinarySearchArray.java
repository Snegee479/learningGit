package basic;

import java.util.Arrays;
import java.util.Scanner;

	public class BinarySearchArray {
	public static void main(String[] args) {
		int a[]= {23,12,14,13,16,1,4,6,8,9,121,132,151};
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the element to search");
		int key=sc.nextInt();
		Arrays.sort(a);
		System.out.println("sorted values are");
		for(int j:a) {
			System.out.println(j);
		}
		int low=0;
		int high=a.length-1;
		int mid=0;
		while(low<=high) {
			mid=(low+high)/2;
			if(a[mid]==key) {
			System.out.println("element is found at "+(mid+1));
			break;
			}
			else if(a[mid]<key) {
				low=mid+1;
				high=high;
			}
			else {
				low=0;
				high=mid-1;
			}
		}
			
	}
}


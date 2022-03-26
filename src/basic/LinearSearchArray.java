package basic;

import java.util.Arrays;
import java.util.Scanner;

public class LinearSearchArray {
public static void main(String[] args) {
	int a[]= {23,12,14,13,16};
	Scanner sc=new Scanner(System.in);
	System.out.println("enter the element to search");
	int key=sc.nextInt();
	Arrays.sort(a);
	System.out.println("Array elements are below:");
	System.out.println(Arrays.toString(a));
	
	int flag=0;
	int indexValue=0;
	for(int i=0;i<a.length;i++) {
	if(a[i]==key) {
		indexValue=i;
		flag=1;
		break;
	}
	else {
		
		flag=0;
	}
	
	}
	
	if(flag==1) {
		System.out.println("element "+key+" is found at index "+indexValue);
		//
	}
	else {
		System.out.println("element is not found");
	}
}
}

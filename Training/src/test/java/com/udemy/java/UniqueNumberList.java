package com.udemy.java;

import java.util.ArrayList;

public class UniqueNumberList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {4,5,5,5,4,6,4,9,6,8};
		// print unique number from the list
		
		ArrayList<Integer> al=new ArrayList<Integer>();
		for(int i= 0; i< a.length; i++) {
			int k = 0;
			
			if(!al.contains(a[i])) {
				al.add(a[i]);
				k=k+1;
				
				for(int j = i + 1; j < a.length; j++) {
					if(a[i] == a[j])
						k++;
				}
//				System.out.println(a[i]);
//				System.out.println(k);
				if(k==1)
					System.out.println(a[i] + " this is unquie number in the list");
			}
		}

	}

}

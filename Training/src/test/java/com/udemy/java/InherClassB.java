package com.udemy.java;

public class InherClassB extends InherClassA{


		int i = 10;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InherClassA a=new InherClassB() ;// it get the value in InherClassA
		System.out.println(a.i);
		
		InherClassB b=new InherClassB() ;// it get the value in InherClassB
		System.out.println(b.i);
		

	}

}

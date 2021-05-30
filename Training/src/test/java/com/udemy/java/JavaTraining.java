package com.udemy.java;

public class JavaTraining {

	public static void main(String[] args) {
		numPatter3();
		
	}
	
	
	public static void numPatter() {
		int count=0;
		for(int i=7;i>=0;i--) {
			
			for(int j=i; j>0; j--) {
				
				count=count+1;
				System.out.print(count+"\t");
			}
			System.out.println("");
		}
		
		
		/*   output
		 *	 1	2	3	4 	 
		 *   5	6	7	
		 *   8	9	
		 *   10                                                  */
	}
	
	
	
	public static void numPatter1() {
		int count=0;
		for(int i=1;i<5;i++) {
			
			for(int j=1; j<=i; j++) {
				
				count=count+1;
				System.out.print(count+"\t");
			}
			System.out.println("");
		}
		
		/*   output
		 *	 1	 	 
		 *   2	3	
		 *   4	5	6	
		 *   7	8	9	10                                         */
	}
	
	public static void numPatter2() {
	
		for(int i=1;i<5;i++) {
			int count=0;
			for(int j=1; j<=i; j++) {
				count=count+1;
				System.out.print(count+"\t");
			}
			System.out.println("");
		}
		
		/*   output
		 *	 1	 	 
		 *   1	2	
		 *   1	2	3	
		 *   1	2	3	4                                         */
	}
	
	public static void numPatter3() {
		int count=0;
		for(int i=1;i<5;i++) {
			
			for(int j=1; j<=i; j++) {
				count=count+3;
				System.out.print(count+"\t");
			}
			System.out.println("");
		}
		
		/*   output
		 *	 3	 	 
		 *   6		9	
		 *   12		15		18
		 *   21		24		27		30                                         */
	}	


}

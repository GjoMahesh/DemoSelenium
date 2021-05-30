package com.udemy.java;

public class ArrayTraining1 {

	public static void main(String[] args) {
		
		int arrNum[][]= {{4,6,5},{8,0,4},{2,4,1}};
		int min = arrNum[0][0];
		int intColumn = 0;
		int row=0;
		int coulmn = 0;
		for(int i = 0; i<3; i++) {
			
			for(int j = 0; j<3; j++) {
				if(arrNum[i][j]<min) {
					min = arrNum[i][j];
					intColumn = j;
					row=i;
					coulmn=j;
				}
			}
		}
		System.out.println("the min number " +min+ " is persent in the index [" +row+"] ["+coulmn+"]");
		
		for(int i = 0; i < 3; i ++) {
			if(arrNum[i][intColumn] > min) {
				min = arrNum[i][intColumn];
			}		
		}
		System.out.println("the max number in coulmn "+coulmn+" is  : "+min+" ");

	}

}

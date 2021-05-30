package com.udemy.java;

import java.util.ArrayList;
import java.util.List;

public class ArrayTraining {

	
	
	public static void main(String[] args) {
 		
		int arrValue[][]= {{11,9,5},{3,4,3},{7,5,3}};
		int min=arrValue[0][0];

	
		 List<String> strArrayIndexLocation = new ArrayList<String>();
		 
		for(int i = 0; i<3 ; i++) {
			for (int j = 0; j<3; j++){
				
				if(arrValue[i][j] == min) {
					
					strArrayIndexLocation.add("["+i+"] ["+j+"]")  ;

				}else if(arrValue[i][j] < min) {
					
						strArrayIndexLocation.clear();
						strArrayIndexLocation.add("["+i+"] ["+j+"]") ;
						
						min=arrValue[i][j];
						
				}
				
				
			}
		}
		
		System.out.println(min);
		System.out.println("the Min value are present in " +strArrayIndexLocation+ " index");
	}

}

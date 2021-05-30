package com.udemy.assignment;

/* Read input from STDIN. Print your output to STDOUT*/

import java.io.*;
import java.util.*;
public class CandidateCode {

   public static int highPrimeValue(int L, int H){
      int count = 0;
	  int min = H - L;
      if(H == 2){
         return 2;
      }else if(H == 3){
         return 3;
      }
      
      for(int i = 2; i <= H/2 ; i++){
         if(H%i==0 && L < H){
            H = H -1;
            i = 1;    
            count ++;
         }
         
      }
      if(count==min) {
    	  return 0;
      }else {
    	  return H;
      }
   }

   public static int lowPrimeValue(int L, int H){
	   int count = 0;
	   int min = H - L;
      if(L == 2){
         return 2;
      }else if(L == 3){
         return 3;
      }
      
      for(int i = 2; i <=  L/2 ; i++){
         if(L==H){
            return L;
         }
         if(L%i==0 && L < H){
            L = L + 1 ;
            i = 1;
            count++;
         }
         
      }
      if(count==min) {
    	  return 0;
      }else {
    	  return L;
      }
   }

   public static int difference(int L, int H){
	   int high= highPrimeValue( L, H);
	   int low = lowPrimeValue( L, H);
      int max_diff =  high - low ;
      if(high==0 && low==0) {
    	  return -1;
      }
	return max_diff;
   }



   
public static void main(String args[] ) throws Exception {

	//Write code here
	   
	        Scanner input = new Scanner(System.in);
	        int L=0,R=0,TC=0;
	        TC = input.nextInt();
	   
	        
	        for(int i=1; i <= TC; i ++) { 
	        	L = input.nextInt();
	        	R = input.nextInt();
	        	System.out.println(difference(L,R));
	        }

   }
}


package com.udemy.assignment;


import java.util.Scanner;

public class PrimeGame {

	public static int HighPrime(int L, int H) {
		
		int i = 1;
		
		if(H==2) {
			return 2;
		}
		
		while(L < H && i <= H/2) {
			i++;
			if(H%i==0 ) {
				H--;
				i=1;
			}
		}
		return H;
	}
	
	public static int LowPrime(int L, int H) {
		
		int j = 1;
		
		if(L == 2) {
			return 2;
		}
		while(L < H && j <= L/2) {
			j++;
			if(L%j==0 ) {
				L++;
				j=1;
			}
		}
		return L;
	}
	
	public static int difference(int L, int H) {
		
		int highPrimeValue = HighPrime(L,H);
		int lowPrimeValue = LowPrime(L,H);
		
		int k = 2;
		while(k <= highPrimeValue/2) {
			
			if(highPrimeValue%k==0 ) {
				k = 2;
				return -1;
			}
			
			k++;
		}
		
		
		int sub = highPrimeValue - lowPrimeValue;
		return sub;
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		


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

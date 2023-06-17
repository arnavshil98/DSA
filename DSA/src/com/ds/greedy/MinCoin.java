package com.ds.greedy;

public class MinCoin {

	public static void main(String[] args) {
		
		 int remainingAmt = 52;
		    int[] coins = {10,5,2,1};
		    for(int i=0; i<coins.length; i++){
		       int countOfCoins = remainingAmt/coins[i];
		       remainingAmt = remainingAmt - (coins[i] * countOfCoins);
		      
		    
		      if(remainingAmt<0){
		      break;
		    }
		    
		     System.out.println("coins of denomination:"+ coins[i]+" and count: "+  countOfCoins);
		  }

	}

}

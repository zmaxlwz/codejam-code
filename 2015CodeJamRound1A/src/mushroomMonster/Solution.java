package mushroomMonster;

import java.util.*;

public class Solution {

	public static int getMethd1Num(int[] mushroomNum){
		int length = mushroomNum.length;
		int result = 0;
		for(int i=0;i<length-1;i++){
			if(mushroomNum[i]>mushroomNum[i+1]){
				result += mushroomNum[i] - mushroomNum[i+1];
			}
		}
		
		return result;
	}
	
	public static int getMethod2Num(int[] mushroomNum){
		int constantRate = Integer.MIN_VALUE;
		int length = mushroomNum.length;
		for(int i=0;i<length-1;i++){
			if(mushroomNum[i]-mushroomNum[i+1] > constantRate){
				constantRate = mushroomNum[i]-mushroomNum[i+1];
			}
		}
		int result = 0;
		for(int i=0;i<length-1;i++){
			if(mushroomNum[i]<=constantRate){
				result += mushroomNum[i];
			}
			else{
				result += constantRate;
			}
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		int testNum = scan.nextInt();
		for(int i=1;i<=testNum;i++){
			int numIntervals = scan.nextInt();
			int[] mushroomNum = new int[numIntervals];
			for(int j=0;j<numIntervals;j++){
				mushroomNum[j] = scan.nextInt();
			}
			int method1Result = Solution.getMethd1Num(mushroomNum);
			int method2Result = Solution.getMethod2Num(mushroomNum);
			System.out.printf("Case #%d: %d %d\n", i, method1Result, method2Result);
		}
		scan.close();
	}

}

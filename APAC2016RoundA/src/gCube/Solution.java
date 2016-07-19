package gCube;

import java.util.*;

public class Solution {

	public static double getDimLength(int[] dimLength, int l, int r){
		
		double logMeanResult = 0;
		for(int i=l;i<=r;i++){
			if(dimLength[i] == 0){
				return 0;
			}
			//natural log
			logMeanResult += Math.log(dimLength[i]);
		}		
		double dimNum = r-l+1;
		logMeanResult = logMeanResult/dimNum;
		
		return Math.exp(logMeanResult);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		int testNum = scan.nextInt();
		for(int i=1;i<=testNum;i++){
			//number of dimensions
			int n = scan.nextInt();
			//number of queries
			int m = scan.nextInt();
			//n dimension length
			int[] dimLength = new int[n];
			for(int j=0;j<n;j++){
				dimLength[j] = scan.nextInt();
			}
			System.out.println("Case #" + i + ":");
			for(int j=0;j<m;j++){
				//process m queries
				int l = scan.nextInt();
				int r = scan.nextInt();
				double dimLen = Solution.getDimLength(dimLength, l, r);
				System.out.printf("%.9f\n", dimLen);
			}
		}
		scan.close();
	}

}

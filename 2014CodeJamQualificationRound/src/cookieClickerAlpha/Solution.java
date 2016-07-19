package cookieClickerAlpha;

import java.util.*;

public class Solution {

	public static double getMinTime(double C, double F, double X){
		double totalTime = 0;
		double rate = 2;
		while(true){
			double time1 = X/rate;
			double time2 = C/rate + X/(rate+F);
			if(time1 <= time2){
				totalTime += time1;
				return totalTime;
			}
			else{
				totalTime += C/rate;
				rate += F;
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		int testNum = scan.nextInt();
		for(int i=1;i<=testNum;i++){
			double C = scan.nextDouble();
			double F = scan.nextDouble();
			double X = scan.nextDouble();
			//System.out.printf("%f %f %f\n", C, F, X);
			double minTime = Solution.getMinTime(C, F, X);
			System.out.printf("Case #%d: %.7f\n", i, minTime);
		}
		scan.close();
	}

}

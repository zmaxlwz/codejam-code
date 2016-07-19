package googolString;

import java.util.*;

public class Solution {

	public static int getBit(long K){
		long[] lengthArray = new long[70];
		long length = 0;
		int maxIndex = 0;
		for(int i=0;i<70;i++){
			maxIndex = i;
			lengthArray[i] = length;
			if(length <= (Long.MAX_VALUE-1)/2){
				length = length*2+1;
			}
			else{
				break;
			}
		}
		int index = maxIndex;
		int flipTimes = 0;
		while(index>1){
			while(lengthArray[index]>=K){
				index--;
			}
			//System.out.println(lengthArray[index]);
			if(K==lengthArray[index]+1){
				break;
			}
			else{
				K = lengthArray[index+1] - K + 1;
				flipTimes++;
			}
			if(K==1){
				break;
			}
		}
		
		if(flipTimes%2==0){
			return 0;
		}
		else{
			return 1;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int testNum = scan.nextInt();
		for(int i=0;i<testNum;i++){
			long K = scan.nextLong();
			int bit = Solution.getBit(K);
			System.out.printf("Case #%d: %d\n", i+1, bit);
		}
		scan.close();
	}

}

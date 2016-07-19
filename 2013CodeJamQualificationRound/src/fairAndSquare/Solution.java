package fairAndSquare;

import java.util.*;

public class Solution {

	public static long getNumFairAndSquare(long A, long B){
		long count = 0;
		for(long i=A;i<=B;i++){
			
			double root = Math.sqrt(i);
			long rootLong = (long)root;
			if(rootLong*rootLong != i){
				continue;
			}
			if(isPalindrome(rootLong) && isPalindrome(i)){
				count++;
				//System.out.println(i);
			}
		}
		
		return count;
	}
	
	private static boolean isPalindrome(long x){
		String s = String.valueOf(x);
		int length = s.length();
		if(length == 1){
			return true;
		}
		int left = 0;
		int right = length-1;
		while(left<right){
			char c1 = s.charAt(left);
			char c2 = s.charAt(right);
			if(c1!=c2){
				return false;
			}
			left++;
			right--;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		int testNum = scan.nextInt();
		for(int i=1;i<=testNum;i++){
			long A = scan.nextLong();
			long B = scan.nextLong();
			long num = Solution.getNumFairAndSquare(A, B);
			System.out.printf("Case #%d: %d\n", i, num);
		}
		scan.close();
	}

}

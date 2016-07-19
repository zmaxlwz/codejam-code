package standingOvation;

import java.util.*;

public class Solution {

	public static int getNumInvitation(int maxLevel, String s){
		int numAudience = 0;
		int length = s.length();
		int numInvitation = 0;
		for(int i=0;i<length;i++){
			if(numAudience < i){
				numInvitation += i-numAudience;
				numAudience += i-numAudience;
			}
			numAudience += s.charAt(i)-'0';
		}
		
		return numInvitation;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		int testNum = scan.nextInt();
		for(int i=1;i<=testNum;i++){
			int maxLevel = scan.nextInt();
			String s = scan.next();
			int numInvitation = Solution.getNumInvitation(maxLevel, s);
			System.out.printf("Case #%d: %d\n", i, numInvitation);
		}
		scan.close();
	}

}

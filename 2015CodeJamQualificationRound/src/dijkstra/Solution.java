package dijkstra;

import java.util.*;

public class Solution {

	public static boolean convertable(int sLen, long times, String s){
		int[][] table = {{1,2,3,4}, {2,-1,4,-3}, {3,-4,-1,2}, {4, 3, -2, -1}};
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('i', 2);
		map.put('j', 3);
		map.put('k', 4);
		int result = 0;
		
		for(long i=0;i<times;i++){
			for(int j=0;j<sLen;j++){
				char c = s.charAt(j);
				if(result == 0){
					result = map.get(c);
				}
				else if(result<0){
					result = (-1)*table[-result-1][map.get(c)-1];
				}
				else{
					//result>0
					result = table[result-1][map.get(c)-1];
				}
			}			
		}		
		if(result != -1){
			return false;
		}
		
		boolean has_i = false;
		boolean has_j = false;
		result = 0;
		
		for(long i=0;i<times;i++){
			for(int j=0;j<sLen;j++){
				char c = s.charAt(j);
				if(result == 0){
					result = map.get(c);
				}
				else if(result<0){
					result = (-1)*table[-result-1][map.get(c)-1];
				}
				else{
					//result>0
					result = table[result-1][map.get(c)-1];
				}
				if(!has_i && result == 2){
					has_i = true;
					result = 0;
				}
				if(has_i && !has_j && result == 3){
					has_j = true;
				}
				if(has_i && has_j && (j<sLen-1 || i<times-1)){
					return true;
				}
			}			
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		int testNum = scan.nextInt();
		for(int i=1;i<=testNum;i++){
			int sLen = scan.nextInt();
			long times = scan.nextLong();
			String s = scan.next();
			boolean convertable = Solution.convertable(sLen, times, s);
			if(convertable){
				System.out.printf("Case #%d: YES\n", i);
			}
			else{
				System.out.printf("Case #%d: NO\n", i);
			}
		}
		scan.close();
	}

}

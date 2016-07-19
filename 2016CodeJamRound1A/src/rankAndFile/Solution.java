package rankAndFile;

import java.util.*;

public class Solution {

	public static int[] getMissingLine(int N, int[][] arrays){
		int[] line = new int[N];
		int index = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0;i<2*N-1;i++){
			for(int j=0;j<N;j++){
				int elem = arrays[i][j];
				if(map.containsKey(elem)){
					map.put(elem, map.get(elem)+1);
				}
				else{
					map.put(elem, 1);
				}
			}
		}
		
		for(Map.Entry<Integer, Integer> entry: map.entrySet()){
			if(entry.getValue()%2==1){
				line[index++] = entry.getKey();
			}
		}
		Arrays.sort(line);
		return line;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		int testNum = scan.nextInt();
		for(int i=1;i<=testNum;i++){
			int N = scan.nextInt();
			int[][] arrays = new int[2*N-1][N];
			for(int j=0;j<2*N-1;j++){
				for(int k=0;k<N;k++){
					arrays[j][k] = scan.nextInt();
				}
			}
			System.out.printf("Case #%d:", i);
			int[] line = Solution.getMissingLine(N, arrays);
			for(int m=0;m<N;m++){
				System.out.printf(" %d", line[m]);
			}
			System.out.println();
		}
		scan.close();
	}

}

package magicTrick;

import java.util.*;

public class Solution {

	public static int getCard(int guess1, int[][] arrange1, int guess2, int[][] arrange2){
		HashSet<Integer> cards = new HashSet<Integer>();
		for(int i=0;i<4;i++){
			cards.add(arrange1[guess1-1][i]);
		}
		int numCards = 0;
		int cardMark = 0;
		for(int i=0;i<4;i++){
			if(cards.contains(arrange2[guess2-1][i])){
				cardMark = arrange2[guess2-1][i];
				numCards++;
			}
		}
		if(numCards == 0){
			return 0;
		}
		else if(numCards == 1){
			return cardMark;
		}
		else{
			return -1;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		int testNum = scan.nextInt();
		for(int i=1;i<=testNum;i++){
			int guess1 = scan.nextInt();
			int[][] arrange1 = new int[4][4];
			for(int j=0;j<4;j++){
				for(int k=0;k<4;k++){
					arrange1[j][k] = scan.nextInt();
				}
			}
			int guess2 = scan.nextInt();
			int[][] arrange2 = new int[4][4];
			for(int j=0;j<4;j++){
				for(int k=0;k<4;k++){
					arrange2[j][k] = scan.nextInt();
				}
			}
			int result = Solution.getCard(guess1, arrange1, guess2, arrange2);
			System.out.printf("Case #%d: ", i);
			if(result == -1){
				System.out.println("Bad magician!");
			}
			else if(result == 0){
				System.out.println("Volunteer cheated!");
			}
			else{
				System.out.println(result);
			}
		}
		scan.close();

	}

}

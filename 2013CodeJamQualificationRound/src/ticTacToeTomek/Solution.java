package ticTacToeTomek;

import java.util.*;

public class Solution {

	public static String checkState(String[] states){
		char[][] cells = new char[4][4];
		for(int i=0;i<4;i++){
			cells[i] = states[i].toCharArray();
		}
		
		int[] xRows = new int[4];
		int[] xCols = new int[4];
		int[] xDiags = new int[2];
		int[] oRows = new int[4];
		int[] oCols = new int[4];
		int[] oDiags = new int[2];
		int dotNum = 0;
		
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				char c = cells[i][j];
				if(c == 'X'){
					xRows[i]++;
					if(xRows[i] == 4){
						return "X won";
					}
					xCols[j]++;
					if(xCols[j] == 4){
						return "X won";
					}
					if(i == j){
						xDiags[0]++;
						if(xDiags[0] == 4){
							return "X won";
						}
					}
					else if(i+j==3){
						xDiags[1]++;
						if(xDiags[1] == 4){
							return "X won";
						}
					}
				}
				else if(c == 'O'){
					oRows[i]++;
					if(oRows[i] == 4){
						return "O won";
					}
					oCols[j]++;
					if(oCols[j] == 4){
						return "O won";
					}
					if(i == j){
						oDiags[0]++;
						if(oDiags[0] == 4){
							return "O won";
						}
					}
					else if(i+j==3){
						oDiags[1]++;
						if(oDiags[1] == 4){
							return "O won";
						}
					}
					
				}
				else if(c == 'T'){
					xRows[i]++;
					if(xRows[i] == 4){
						return "X won";
					}
					xCols[j]++;
					if(xCols[j] == 4){
						return "X won";
					}
					oRows[i]++;
					if(oRows[i] == 4){
						return "O won";
					}
					oCols[j]++;
					if(oCols[j] == 4){
						return "O won";
					}
					if(i == j){
						xDiags[0]++;
						if(xDiags[0] == 4){
							return "X won";
						}
						oDiags[0]++;
						if(oDiags[0] == 4){
							return "O won";
						}
					}
					else if(i+j==3){
						xDiags[1]++;
						if(xDiags[1] == 4){
							return "X won";
						}
						oDiags[1]++;
						if(oDiags[1] == 4){
							return "O won";
						}
					}
					
				}
				else{
					dotNum++;
				}
			}
		}
		
		if(dotNum == 0){
			return "Draw";
		}
		else{
			return "Game has not completed";
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		int testNum = scan.nextInt();
		for(int i=1;i<=testNum;i++){
			String[] states = new String[4];
			for(int j=0;j<4;j++){
				states[j] = scan.next();
			}
			String result = Solution.checkState(states);
			System.out.printf("Case #%d: %s\n", i, result);
		}
		scan.close();
	}

}

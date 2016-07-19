package senateEvacuation;

import java.util.*;

public class Solution {

	public static String getEvacuationPlan(int numParties, int[] partyPeopleCount){
		char[] partyName = new char[numParties];
		for(int i=0;i<numParties;i++){
			partyName[i] = (char)('A'+i);
		}
		
		int numTotalPeople = 0;
		for(int i=0;i<numParties;i++){
			numTotalPeople += partyPeopleCount[i];
		}
		
		String plan = "";
		while(numTotalPeople>0){
			int maxIndex = Solution.getMaxIndex(partyPeopleCount, numParties);
			int nextMaxIndex = Solution.getNextMaxIndex(partyPeopleCount, numParties, maxIndex);
			int maxValue = partyPeopleCount[maxIndex];
			int nextMaxValue = partyPeopleCount[nextMaxIndex];
			
			if(maxValue>=2){
				//evacuate two of max party
				partyPeopleCount[maxIndex] -= 2;
				numTotalPeople -= 2;
				int newMaxIndex = Solution.getMaxIndex(partyPeopleCount, numParties);
				if(partyPeopleCount[newMaxIndex] > numTotalPeople/2){
					//recover
					partyPeopleCount[maxIndex] += 2;
					numTotalPeople += 2;
				}
				else{
					plan += String.valueOf(partyName[maxIndex]);
					plan += String.valueOf(partyName[maxIndex]);
					plan += " ";
					continue;
				}
			}
			
			if(nextMaxValue>=1){
				//evacuate one of max party, one of next max party
				partyPeopleCount[maxIndex]--;
				partyPeopleCount[nextMaxIndex]--;
				numTotalPeople -= 2;
				int newMaxIndex = Solution.getMaxIndex(partyPeopleCount, numParties);
				if(partyPeopleCount[newMaxIndex] > numTotalPeople/2){
					//recover
					partyPeopleCount[maxIndex]++;
					partyPeopleCount[nextMaxIndex]++;
					numTotalPeople += 2;
				}
				else{
					plan += String.valueOf(partyName[maxIndex]);
					plan += String.valueOf(partyName[nextMaxIndex]);
					plan += " ";
					continue;
				}
			}
			
			//evacuate one from max party
			partyPeopleCount[maxIndex]--;
			numTotalPeople--;
			plan += String.valueOf(partyName[maxIndex]);
			plan += " ";
			
		}
		
		return plan;
	}
	
	public static int getMaxIndex(int[] nums, int count){
		
		int maxIndex = -1;
		int maxValue = Integer.MIN_VALUE;
		for(int i=0;i<count;i++){
			if(nums[i]>maxValue){
				maxValue = nums[i];
				maxIndex = i;
			}
		}
		
		return maxIndex;
		
	}
	
	public static int getNextMaxIndex(int[] nums, int count, int maxIndex){
		
		int nextMaxIndex = -1;
		int nextMaxValue = Integer.MIN_VALUE;
		for(int i=0;i<count;i++){
			if(i != maxIndex && nums[i]>nextMaxValue){
				nextMaxValue = nums[i];
				nextMaxIndex = i;
			}
		}
		return nextMaxIndex;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		int testNum = scan.nextInt();
		for(int i=1;i<=testNum;i++){
			int numParties = scan.nextInt();
			int[] partyPeopleCount = new int[numParties];
			for(int j=0;j<numParties;j++){
				partyPeopleCount[j] = scan.nextInt();
			}
			String plan = Solution.getEvacuationPlan(numParties, partyPeopleCount);
			System.out.printf("Case #%d: %s\n", i, plan.trim());
		}
		scan.close();
	}

}

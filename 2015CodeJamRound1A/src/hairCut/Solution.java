package hairCut;

import java.util.*;

public class Solution {

	public static int getBarberIndex(int[] barberCutTime, long N){
		int numBarber = barberCutTime.length;
		PriorityQueue<Barber> queue = new PriorityQueue<Barber>(numBarber, new BarberComparator());
		//int[] barberAvailableTime = new int[numBarber];
		for(int i=0;i<numBarber;i++){
			queue.offer(new Barber(i, 0));
			//barberAvailableTime[i] = 0;
		}
		
		int barberIndex = 0;
		for(long i=1;i<=N;i++){
			//barberIndex = getMinIndex(barberAvailableTime);
			Barber b = queue.poll();
			barberIndex = b.index;
			b.availableTime += barberCutTime[barberIndex];
			queue.offer(b);
			//barberAvailableTime[barberIndex] += barberCutTime[barberIndex];
		}
		
		return barberIndex+1;
	}
	
	public static int getBarberIndex2(int[] barberCutTime, long N){
		int maxCutTime = Integer.MIN_VALUE;
		int length = barberCutTime.length;
		for(int i=0;i<length;i++){
			if(barberCutTime[i] > maxCutTime){
				maxCutTime = barberCutTime[i];
			}
		}
		
		long left = -1;
		long right = N*maxCutTime;
		long middle = 0;
		long targetMinute = 0;
		while(left<right){
			middle = (left+right)/2;
			long numCustomerToThisMinute = numServedCustomer(barberCutTime, middle); 
			long numCustomerToLastMinute = numServedCustomer(barberCutTime, middle-1);
			if(numCustomerToThisMinute>= N && numCustomerToLastMinute<N){
				targetMinute = middle;
				break;
			}
			else if(numCustomerToThisMinute < N){
				left = middle+1;
			}
			else{
				right = middle-1;
			}
		}
		if(left==right){
			targetMinute = left;
		}
		long numCustomerBeforeTargetMinute = numServedCustomer(barberCutTime, targetMinute-1);
		long index = N - numCustomerBeforeTargetMinute;
		int barberIndex = 0;
		for(int i=0;i<length;i++){
			if(targetMinute % barberCutTime[i] == 0){
				barberIndex++;
			}
			if(barberIndex == index){
				return i+1;
			}
		}
		return 0;
	}
	
	private static long numServedCustomer(int[] barberCutTime, long time){
		if(time<0){
			return 0;
		}
		
		long numServedCustomer = 0;
		int length = barberCutTime.length;
		for(int i=0;i<length;i++){
			numServedCustomer += time/barberCutTime[i] + 1;
		}
		
		return numServedCustomer;
	}
	
	/*
	private static int getMinIndex(int[] array){
		int length = array.length;
		int minValue = array[0];
		int minIndex = 0;
		for(int i=1;i<length;i++){
			if(array[i]<minValue){
				minValue = array[i];
				minIndex = i;
			}
		}
		
		return minIndex;
	}
	*/
	
	public static long getNumCustomerInCycle(int[] barberCutTime){
		int length = barberCutTime.length;
		//get the least common multiple
		int gcd = barberCutTime[0];
		for(int i=1;i<length;i++){
			gcd = getGCD(gcd, barberCutTime[i]);
		}
		//System.out.println(gcd);
		long lcm = gcd;
		for(int i=0;i<length;i++){
			lcm = barberCutTime[i]/gcd*lcm;
			//System.out.println(lcm);
			if(lcm>Integer.MAX_VALUE){
				//System.out.println("return Integer.max: " + Integer.MAX_VALUE);
				return Integer.MAX_VALUE;
			}
		}
		
		long numCustomerInCycle = 0;
		for(int i=0;i<length;i++){
			numCustomerInCycle += lcm/barberCutTime[i];
			if(numCustomerInCycle > Integer.MAX_VALUE){
				return Integer.MAX_VALUE;
			}
		}
		//System.out.println(numCustomerInCycle);
		return numCustomerInCycle;
	}
	
	private static int getGCD(int a, int b){
		
		if(a == 0){
			return b;
		}
		while(b>0){
			int temp = b;
			b = a%b;
			a = temp;
		}
		return a;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		int testNum = scan.nextInt();
		for(int i=1;i<=testNum;i++){
			int numBarber = scan.nextInt();
			long N = scan.nextLong();
			int[] barberCutTime = new int[numBarber];
			for(int j=0;j<numBarber;j++){
				barberCutTime[j] = scan.nextInt();
			}
			/*
			long numCustomerInCycle = Solution.getNumCustomerInCycle(barberCutTime);
			//System.out.println("here1");
			N = N%numCustomerInCycle;
			if(N==0){
				N = numCustomerInCycle;
			}
			//System.out.println("here2");
			//System.out.println(N);
			int barberIndex = Solution.getBarberIndex(barberCutTime, N);
			//System.out.println("here3");
			 * 
			 */
			int barberIndex = Solution.getBarberIndex2(barberCutTime, N);
			System.out.printf("Case #%d: %d\n", i, barberIndex);
		}
		scan.close();
	}

}

class Barber{
	int index;
	long availableTime;
	public Barber(int index, int time){
		this.index = index;
		this.availableTime = time;
	}
}

class BarberComparator implements Comparator<Barber>{
	
	public int compare(Barber b1, Barber b2){
		if(b1.availableTime < b2.availableTime){
			return -1;
		}
		else if(b1.availableTime > b2.availableTime){
			return 1;
		}
		else if(b1.index < b2.index){
			return -1;
		}
		else if(b1.index > b2.index){
			return 1;
		}
		else{
			return 0;
		}
		
	}
}

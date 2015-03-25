package asgn03;

public class Knapsack {

	private int[][] knap;

	
	/**
	 * Only works if both v and w arrays have a 0
	 * in the 0th position, followed by the remaining numbers.
	 * This also means that n has to be increased by 1.
	 */
	public Knapsack(int[] v, int[] w, int n, int W){
		knap = new int[n+1][W + 1];
		doKnapsack(v,w,n,W);
	}
	
	private void doKnapsack(int[]v, int[]w,int n, int W){
		for (int i = 1; i <= n; i++){
			for (int j = 0; j <= W; j++){
				if (j - w[i] >= 0)
					knap[i][j] = Math.max(knap[i-1][j], v[i] + knap[i-1][j-w[i]]);
				else
					knap[i][j] = knap[i-1][j];
			}
		}
	}
	
	public void printKnapsack(){
		for (int i = 0; i < knap.length; i++){
			for (int j = 0; j < knap[0].length; j++){
				if (j == knap[0].length - 1)
					System.out.println(knap[i][j]);
				else
					System.out.print(knap[i][j] + "\t");
			}
		}
	}
	
	public int[][] getKnapsack(){
		return knap;
	}


}

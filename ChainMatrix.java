package asgn03;

public class ChainMatrix {

	int [] d;
	int [][] cost;

	public ChainMatrix(int [] dim){
		d = dim;
		cost = new int[d.length - 1][d.length - 1];
		doChainMatrix();
	}

	private void doChainMatrix(){
		for (int b = 1; b < d.length - 1; b++){
			for (int i = 0; i < d.length - 1; i++){
				int j = i + b;
				if (j >= cost.length)
					continue;
				cost[i][j] = Integer.MAX_VALUE;
				for (int k = i; k <= j - 1; k++){
					int thisCost = cost[i][k] + cost[k+1][j] + d[i]*d[k+1]*d[j+1];
					if (thisCost < cost[i][j]){
						cost[i][j] = thisCost;
						cost[j][i] = k;
					}
				}
			}
		}
	}
	public int[][] getChainMatrix(){
		return cost;
	}
	public void printChainMatrix(){
		for (int i = 0; i < cost.length; i++){
			for (int j = 0; j < cost[0].length; j++){
				if (j == cost[0].length - 1)
					System.out.println(cost[i][j]);
				else
					System.out.print(cost[i][j] + "\t");
			}
		}
	}
}

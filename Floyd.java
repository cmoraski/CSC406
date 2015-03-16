package asgn03;

public class Floyd {

	int[][] d;
	
	public Floyd(int[][] w){
		d = new int[w.length][w.length];
		for (int i = 0; i < w.length; i++){
			for (int j = 0; j < w.length; j++){
				if (w[i][j] == 0 && i != j)
					d[i][j] = Integer.MAX_VALUE;
				else
					d[i][j] = w[i][j];
			}
		}
		doFloyds();
	}
	
	private void doFloyds(){
		for (int k = 0; k < d.length; k++){
			for (int i = 0; i < d.length; i++){
				for (int j = 0; j < d.length; j++){
					int thisStep = d[i][k] + d[k][j];
					if (thisStep < 0)
						continue;
					d[i][j] = Math.min(d[i][j], thisStep);
				}
			}
		}
	}
	
	public int[][] getFloyds(){
		return d;
	}
	
}

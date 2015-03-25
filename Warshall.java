package asgn03;

public class Warshall {

	int [][] r;

	public Warshall(int[][]a){
		r = new int[a.length][a.length];
		for (int i = 0; i < a.length; i++){
			for (int j = 0; j < a[0].length; j++)
				r[i][j] = a[i][j];
		}
		doWarshalls();	
	}
	
	private void doWarshalls(){
		for (int k = 0; k < r.length; k++){
			for (int i = 0; i < r.length; i++){
				for (int j = 0; j < r.length; j++){
					if (r[i][k] == 1 && r[k][j] == 1)
						r[i][j] = 1;
				}
			}
		}
	}
	
	public void printWarshalls(){
		for (int i = 0; i < r.length; i++){
			for (int j = 0; j < r[0].length; j++){
				if (j == r[0].length - 1)
					System.out.println(r[i][j]);
				else
					System.out.print(r[i][j] + "\t");
			}
		}
	}
	
	public int[][] getWarshalls(){
		return r;
	}
	

}

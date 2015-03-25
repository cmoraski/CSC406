package asgn03;

public class Floyd {

	int[][] d;
	int[][] p;

	public Floyd(int[][] w) {
		d = new int[w.length][w.length];
		p = new int[w.length][w.length];
		for (int i = 0; i < w.length; i++) {
			for (int j = 0; j < w.length; j++) {
				if (w[i][j] == 0 && i != j)
					d[i][j] = Integer.MAX_VALUE;
				else
					d[i][j] = w[i][j];
			}
		}
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < p[0].length; j++)
				if (d[i][j] == Integer.MAX_VALUE)
					p[i][j] = -1;
				else
					p[i][j] = i;
		}
		for (int i = 0; i < p.length; i++)
			p[i][i] = i;
		doFloyds();
	}

	private void doFloyds() {
		for (int k = 0; k < d.length; k++) {
			for (int i = 0; i < d.length; i++) {
				for (int j = 0; j < d.length; j++) {

					if (d[i][k] == Integer.MAX_VALUE
							|| d[k][j] == Integer.MAX_VALUE)
						continue;

					int thisStep = d[i][k] + d[k][j];
					if (thisStep < d[i][j]){
						d[i][j] = Math.min(d[i][j], thisStep);
						p[i][j] = p[k][j];
					}
				}
			}
		}
	}

	public String getPath(int i, int j) {
		String path = j + "";
		boolean wasPath = false;
		while(p[i][j] != i){
			wasPath = true;
			path = p[i][j] + " -> " + path;
			j = p[i][j];
		}
		if (wasPath)
			path = i + " -> " + path;
		else
			path = "NO PATH EXISTS!";
		return path;
	}

	public void printFloyds() {
		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d[0].length; j++) {
				if (j == d[0].length - 1)
					System.out.println(d[i][j]);
				else
					System.out.print(d[i][j] + "\t");
			}
		}
	}

	public int[][] getFloyds() {
		return d;
	}

}

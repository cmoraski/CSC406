package asgn04;

/** Class to hold
 * n(x), n'(x), r(x), r'(x)
 * for SplayTree  
 */
public class RankAndSize {

	//n(x)
	private int nx;
	//n'(x)
	private int npx;
	//r(x)
	private int rx;
	//r'(x)
	private int rpx;
	
	/** Constructor for full RankAndSize Class **/
	public RankAndSize(int n, int np, int r, int rp){
		nx = n;
		npx = np;
		rx = r;
		rpx = rp;
	}
	/** Constructor for half RankAndSize Class 
	 * other values should be added in after splay
	 */
	public RankAndSize(int n, int r){
		nx = n;
		rx = r;
	}
	public void setNPX(int np){
		npx = np;
	}
	public void setRPX(int rp){
		rpx = rp;
	}
	public int getNX(){
		return nx;
	}
	
	public int getNPX(){
		return npx;
	}
	
	public int getRX(){
		return rx;
	}
	
	public int getRPX(){
		return rpx;
	}
	
	public String toString(){
		return "n(x) = " + nx + " n'(x) = " + npx + "\nr(x) = " +
				rx + " r'(x) = " + rpx;
	}
	
}

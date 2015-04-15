package asgn04;

/** Class to hold
 * n(x), n'(x), r(x), r'(x)
 * for SplayTree  
 */
public class RankAndSize<T> {

	private T data;
	//		   	n(x)   n'(x)   r(x)   r'(x)
	private int	nx,	   npx,	   rx,    rpx;

	
	/** 
	 * Constructor for half RankAndSize Class 
	 * other values should be added in ensuing splay
	 */
	public RankAndSize(T d, int n, int r){
		data = d;
		nx = n;
		rx = r;
		npx = 0;
		rpx = 0;
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
		return "Ranks and Sizes for subsplay operation on the data: " + data + "\nBefore: n(x) = " + 
				nx + " r(x) = " + rx + "\nAfter: n'(x) = " + npx + " r'(x) = " + rpx;
	}
	
}

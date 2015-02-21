package asgn02;

import java.util.ArrayList;
import java.util.Scanner;

//Adjacency List Directed Graph
public class ALDG extends ALGraph{

	public ALDG(Scanner sc) {
		super(sc);
		
		inDegree = new int[numNodes];
		outDegree = new int [numNodes];
		
		String[] theEdges = sc.nextLine().split(" ");

		for(int i = 0 ; i < theEdges.length; i+=2){
			putEdge(new Edge(new Node(Integer.parseInt(theEdges[i])), new Node(Integer.parseInt(theEdges[i+1])), 0));
		}
	}

	public boolean existEdge(int i, int j){
		if (outBounds(i) || outBounds(j))
			return false;

		ALNode temp = theGraph[i];
		while(temp != null){
			if (temp.getNode().equals(new Node(j)))
				return true;
			temp = temp.getNextNode();
		}
		return false;
	}

	public boolean putEdge(int i, int j, int weight) {
		if (outBounds(i) || outBounds(j))
			return false;

		ALNode newNode = new ALNode(new Node(j), weight, theGraph[i]);
		theGraph[i] = newNode;
		outDegree[i]++;
		inDegree[j]++;
		numEdges++;
		return true;
	}

	public boolean removeEdge(int i, int j) {
		if (outBounds(i) || outBounds(j))
			return false;

		ALNode prev = theGraph[i], temp = theGraph[i];
		while (temp != null){
			if (temp.getNode().equals(new Node(j))){
				prev.setNextNode(temp.getNextNode());
				outDegree[i]--;
				inDegree[j]--;
				numEdges--;
				return true;
			}
			else{
				prev = temp;
				temp = temp.getNextNode();
			}
		}
		return false;
	}

	public int degree(int i) {
		return -1;
	}

	public int inDegree(int i) {
		if (outBounds(i))
			return -1;
		return inDegree[i];
	}

	public int outDegree(int i) {
		if (outBounds(i))
			return -1;
		return outDegree[i];
	}

}

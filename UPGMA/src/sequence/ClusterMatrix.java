package sequence;

import java.util.ArrayList;

public class ClusterMatrix {
	double[][] clusterMatrix;
		
	public ClusterMatrix(double[][] distMatrix) {
		this.clusterMatrix = distMatrix;				
	}
	
	private ArrayList<Integer> findMin(){
		ArrayList<Integer> closePair = new ArrayList<Integer>(2);
		double minDistance = Double.POSITIVE_INFINITY;	// Minimum non-zero distance in dissimilarity matrix
		int mSize = this.clusterMatrix.length;
		
		// Array is symmetrical, so you can iterate through half
		for (int i=0; i<mSize; i++) {
			for (int j=i+1; j<mSize; j++) {
				// Initialize the minimum distance with a non-zero value
				if (minDistance == 0) {	
					minDistance = this.clusterMatrix[i][j];
				}
				// Find the minimum non-zero value in the array
				else if (this.clusterMatrix[i][j] != 0) {	
					if (this.clusterMatrix[i][j] < minDistance) {
						minDistance = this.clusterMatrix[i][j];
						closePair.add(0, i);
						closePair.add(1, j);
					}
				}
			}
		}

		return closePair;
	}
	
	
	// Join nearest neighbours and generate new matrix with cluser
	public void joinNearest() {
		int cSize = this.clusterMatrix.length;
		double[][] joinedMatrix = new double[cSize-1][cSize-1];

		ArrayList<Integer> pair;		
		int iskew = 0; // skew position when inserting into new matrix
		int jskew = 0;
		boolean clustered = false;

		pair = findMin();
		System.out.println("Point 1: " + pair.get(0));
		System.out.println("Point 2: " + pair.get(1));
		
		for (int i=0; i<cSize; i++) {

			if(pair.contains(i)){
				for (int j=i+1; j<cSize; j++) {					
					if (pair.contains(j)){
						joinedMatrix[i][i] = 111;
					}
				System.out.println(i + ", " + j + " " + this.clusterMatrix[i][j]);
			}
			



			}
		}

		
	}							
}

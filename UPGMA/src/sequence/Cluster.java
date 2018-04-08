package sequence;

import java.util.ArrayList;

import javax.naming.PartialResultException;

public class Cluster {
	double[][] clusterMatrix;
		
	public Cluster(double[][] distMatrix) {
		this.clusterMatrix = distMatrix;				
	}

	
	private ArrayList<Integer> findMin(){
		ArrayList<Integer> closePair = new ArrayList<Integer>();
		closePair.add(0);
		closePair.add(0);
		double minDistance = Integer.MAX_VALUE;	// Minimum non-zero distance in dissimilarity matrix
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
						closePair.set(0, i);
						closePair.set(1, j);
					}
				}
			}
		}

		return closePair;
	}
	
	
	// Join nearest neighbours and generate new matrix with cluster
	public void joinNearest() {
		int cSize = this.clusterMatrix.length;
		double[][] joinedMatrix = new double[cSize-1][cSize-1];

		ArrayList<Integer> pair;		
		int iskew = 0; // skew position when inserting into new matrix
		int jskew = 0;
		boolean clustered = false;

		pair = findMin();	// Find minimum distance in dissimilarity matrix
		
		//Cluster the nodes with minimum distance and generate a new array
		for (int i=0; i<cSize; i++) {												
			if (pair.contains(i)) {	// Skip columns that will be deleted
				iskew--;			// skew position in new matrix to account for deletions					
			}
			else {
				
				joinedMatrix[i+iskew][joinedMatrix.length -1] = ((this.clusterMatrix[i][pair.get(0)] + this.clusterMatrix[i][pair.get(1)]) /2);
				
				for (int j=i+1; j<cSize; j++) {										
					if(pair.contains(j)) {	// Skip rows that will be deleted
						jskew--;			// skew position in new matrix to account for deletions					
					}
					else {
						// Reposition remaining values into new matrix
						joinedMatrix[i+iskew][j+jskew] = this.clusterMatrix[i][j];					
					}
					
				}
			}			
			jskew = 0;	// reset row skew for next column		
		}
		for (int i=0; i<cSize-1; i++) {
			for (int j=i+1; j<cSize-1; j++) {
				System.out.println("i: " + i + " j: " + j + " Value: " + joinedMatrix[i][j]);
			}
		}
		
		
		
	}							
}
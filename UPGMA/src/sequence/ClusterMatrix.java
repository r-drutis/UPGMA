package sequence;

public class ClusterMatrix {
	float[][] clusterMatrix;
		
	public ClusterMatrix(float[][] distMatrix) {
		this.clusterMatrix = distMatrix;				
	}
	
	
	
	
	
	public void joinNearest() {
		float minDistance = 0;	// Minimum non-zero distance in dissimilarity matrix
		int neighbor1 = 0;			// First sequence in neighbor pair
		int neighbor2 = 0;			// Second sequence in neighbor pair
		int mSize = clusterMatrix.length;
		float[][] joinedMatrix = new float[mSize-1][mSize-1];
		
		for (int i=0; i<mSize; i++) {
			for (int j=i+1; j<mSize; j++) {
				// Initialize the minimum distance with a non-zero value
				if (minDistance == 0) {	
					minDistance = clusterMatrix[i][j];
				}
				// Find the minimum non-zero value in the array
				else if (clusterMatrix[i][j] != 0) {	
					if (clusterMatrix[i][j] < minDistance) {
						minDistance = clusterMatrix[i][j];
						neighbor1 = i;
						neighbor2 = j;
					}
				}								
			}			
		}
		for (int i=0; i<mSize-1; i++) {
			if (i != neighbor1 && i != neighbor2) {
				for (int j=0; j<mSize-1; j++) {
					if (j != neighbor1 && j != neighbor2) {
						
						
					}
				}
			}
		}
		
	
	
	}
	
}

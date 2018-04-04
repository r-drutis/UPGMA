package sequence;

import java.io.IOException;
import java.util.ArrayList;

public class MatrixGenerator {

	public static void main(String[] args) {
		String fasta = "C:\\Users\\rdrutis\\Desktop\\test.fasta";
		FastaReader reader = new FastaReader();
		ArrayList<DNASequence> fastaSequences = new ArrayList<DNASequence>();
		
		try {
			fastaSequences = reader.readFasta(fasta);
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		DisMatrix dmatrix = new DisMatrix(fastaSequences);
		dmatrix.debug();
		dmatrix.calcScores();
		
	}

}

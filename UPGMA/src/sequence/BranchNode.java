package sequence;

public class BranchNode extends Node {
	Node branch1;
	Node branch2;
	
	public BranchNode(Node child1, Node child2) {
		branch1 = child1;
		branch2 = child2;
	}
}

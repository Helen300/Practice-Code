RankNode root = null; 


// OPERATES IN O(LOG N) FOR BALANCED TREE
// O(N) FOR NOT BALANCED
void track(int number) {
	if (root == null) {
		root = new RankNode(number);
	} else {
		root.insert(number);
	}
}

// OPERATES IN O(LOG N) FOR BALANCED TREE
// O(N) FOR NOT BALANCED
int getRankOfNumber(int number) {
	return root.getRank(number);
}

public class RankNode {
	// num smaller than it
	public int left_size = 0;
	// nodes to left and right subtree
	public RankNode left, right; 
	public int data = 0; 
	public RankNode(int d) {
		data = d; 
	}

	public void insert(int d) {
		if (d <= data) {
			// call insert d on the left subtree because not null 
			if (left != null) left.insert(d); 
			else left = new RankNode(d); 
			// increment size of subtree
			left_size++;
		} else {
			if (right != null) right.insert(d);
			else right = new RankNode(d); 
		}
	}



	public int getRank(int d) {
		if (d == data) {
			// if equal to the current node
			return left_size; 
		} else if (d < data) {
			// if it is less  than it, we want to keep going left
			// if null, return -1 because not found
			if (left == null) return -1; 
			else return left.getRank(d);
		} else {
			int right_rank = right == null ? -1 : right.getRank(d); 
			if(right_rank == -1) return -1; 
			else return left_size + 1 + right_rank;
		}
	}
}
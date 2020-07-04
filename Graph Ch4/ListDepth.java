/* Given binary tree, design ALG that creates linked list of
 * all nodes at each depth 
 */ 


ArrayList<LinkedList<TreeNode>> createdLevelLinkedList(TreeNode root) {
	// initialize an array to keep track of all created linked lists per level 
	ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
	
	// visit the root
	LinkedList<TreeNode> current = new LinkedList<TreeNode>();
	if (root != null) {
		// add it to our initial linked list of tree nodes
		current.add(root);
	}

	// while there are nodes remaining in the current linked list
	while (current.size() > 0) {
		// add in the previous level to the result of linked list/level
		result.add(current);
		// make parents = current (reference)
		LinkedList<TreeNode> parents = current; 
		//preparing to make a new linked list for next level
		current = new LinkedList<TreeNode>();
		// for each parent node in LinkedList parents
		for (TreeNode parent : parents) {
			// add its children to current level
			if (parent.left != null) {
				current.add(parent.left);
			}
			if (parent.right != null) {
				current.add(parent.right);
			}
		}
	}
	return result; 
}
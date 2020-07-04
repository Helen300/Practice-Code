// WRITE ALG to find "next" node (in-order successor) og given node
// the left and right 


/* Node inorderSucc(Node n) {
	if (n has right subtree) {
		return leftmost child of right subtree
	} else {
		while (n is a right child of n.parent) {
			// GO UP 
			n = n.parent 
		}
		// parent has not yet been traversed 
		return n.parent
	}
} */ 



// IN ORDER TRAVERSALS
// Left, Root, Right 


TreeNode inorderSucc(TreeNode n) {
	// if node is null, we can go back 
	// hit very end of traversal 
	if (n == null) return null; 


	if (n.right != null) {
		// return leftmost child on the right side
		return leftMostChild(n.right);
	} else {
		TreeNode q = n; 
		TreeNode x = q.parent; 
		// Go up until we're on left instead of right 
		while (x != null && x.left != q) {
			q = x; 
			x = x.parent; 
		}
		// return its parent 
		return x; 
	}

}

TreeNode leftMostChild(TreeNode n) {
	if (n == null) {
		return null; 
	}
	while (n.left != null) {
		n = n.left; 
	}
	return n; 
}
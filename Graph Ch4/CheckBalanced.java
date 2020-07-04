// GIVEN BINARY TREE
// DEVELOP FUNCTION TO CHECK IF TREE IS BALANCED 

int checkHeight(TreeNode root) {
	// NULL TREE height defined to be -1
	if (root == null) return -1; 

	// checking for the height of left subtree (recursively) 
	int leftHeight = checkHeight(root.left);
	// PASS THE ERROR UP
	if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

	int rightHeight = checkHeight(root.right);
	if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

	int heightDiff = leftHeight - rightHeight;
	// if there is a height diff bw the two subtrees of more than 1
	if (Math.abs(heightDiff) > 1) {
		return Integer.MIN_VALUE;
	} else {
		// returning themax of the two heights + 1 for next subtree
		return Math.max(leftHeight, rightHeight) + 1; 
	}
}

boolean isBalanced(TreeNode root) {
	// IF EQUALS THIS, this means there was a height diff of > 1
	// therefore NOT BALANCED
	return checkHeight(root) != Integer.MIN_VALUE;
}


// CODE RUNS IN O(N) TIME AND O(H) space
// O(H) = height of tree 
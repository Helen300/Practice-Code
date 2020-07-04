// Implement function to check if binary tree = BST

// BST = where all left <= current < right 


// we can probably just recursively go through 

// pass dwn min and max values


// 1. BEGIN W/ RANGE min = null, max = null (for root, bc no min or max)


// 2. Branch left, checking that nodes are within (min = NULL, max = ROOT)
// as we branch left, MAX gets updated ( max gets smaller) 


// 3. Branch right, nodes are within (min = ROOT, max = NULL)
// as we branch right, MIN gets updated (min gets bigger)


// 4. If anything fails checks, we stop and return 



// RUNTIME O(N) - MUST GO THROUGH ALL N NODES
// SPACE COMPLEXITY O(LOG N) based on balanced tree
// recursive stack calls (height of tree

// check recursively, passing down new min (right) or max (left)
boolean checkBST(TreeNode n) {
	// starting with root, therefore MIN/MAX SHOULD BE NULL
	return checkBST(n, null, null);
}

boolean checkBST(TreeNode n, int min, int max) {
	// if Treenode = null, we've hit the end of that subtree therfore return
	if (n == null) {
		return true; 
	}

	// if min is not null, and n is less than min
	// or if max not null, n is greater than max
	// RETURN FALSE, NOT VALID BST
	if (min != null && n.data <= min) || (max != null && n.data > max) {
		return false; 
	}

	// if checkBST is not true on both subtrees --> return false 
	if (!checkBST(n.left, min, n.data) || !checkBST(n.right, n.data, max)) {
		return false; 
	}
	return true; 

}


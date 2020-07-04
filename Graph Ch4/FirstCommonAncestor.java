// Given two nodes in Binary Tree

// Write ALGORITHM that finds first common ancestor of two nodes in binary tree
// Return the First Common Ancestor (which is a TreeNode)

// SOLUTION 2 - we monly need to search entire tree once
// bubble up findings to earlier nodes in stack 
// when p and q are no longer on same side -> common ancestor
// RUNS IN O(N) for balanced tree 
// Only recurse through entire tree w/ function 

commonAncestor(TreeNode root, TreeNode p, TreeNode q)
// RETURNS

// p , if root's subtree includes p (not q)
// q, if root's subtree includes q (not p)
// null, if neither are in root's subtree
// else, return common ancestor of p and q

// MAKING A CLASS THAT CAN BE RETURNED FROM RECURSIVE CALLS
class Result {
	public TreeNode node; 
	public boolean isAncestor; 
	public Result(TreeNode n, boolean isAnc) {
		node = n;
		isAncestor = isAnc; 
	}
}

// WHAT WE CALL IN THE BEGINNING
// finding common ancestor given root and two nodes (p, q)
TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	Result r = commonAncestorHelper(root, p, q);
	// if whatever is returned is an ancestor
	// we return that node
	// else return null, there is no ancestor that exists
	if (r.isAncestor) {
		return r.node
	}
	return null; 
}

Result commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {

	// if what was passed in is null, return null and false
	// not an ancestor
	if (root == null) return new Result(null, false);


	// they are the same node, and is the root
	if (root == p && root == q) {
		return new Result(root, true);
	}
	// searching left subtree
	Result rx = commonAncestorHelper(root.left, p, q);
	// found a common ancestor 
	if (rx.isAncestor) { 
		return rx; 
	}

	// searching right subtree
	Result ry = commonAncestorHelper(root.right, p, q);
	if (ry.isAncestor) {
		return ry; 
	}

	if (rx.node != null && ry.node != null) {
		return new Result(root, true); // common ancestor 
	} else if (root == p || root == q) {
		// we're currently at p or q
		// found one of those nodes in subtree, then ancestor
		// flag TRUE
		boolean isAncestor = rx.node != null || ry.node != null; 
		return new Result(root, isAncestor)
	} else {
		return new Result(rx.node != null ? rx.node : ry.node, false);
	}


}





// SOLUTION 1 - SAME METHOD AS FINDING INTERSECTION OF LINKED LISTS
// RUNTIME = O(d) where d = depth of deeper node

TreeNode commonAncestor(TreeNode p, TreeNode q) {
	// find depths of the two nodes 
	int depthP = depth(p);
	int depthQ = depth(q);
	// find difference in depths 
	int diffDepths = depthP - depthQ;
	// q is more shallow
	TreeNode first = diffDepths > 0 ? q : p; 
	// p is more deep
	TreeNode second = diffDepths > 0 ? p : q; 
	// Bring the second one up 
	second = goUpBy(second, Math.abs(delta));

	// FIND INTERSECTING PATH BY GOING UP ONE AT A TIME
	// WHILE THEY ARE NOT THE SAME AND BOTH NOT NULL 
	while (first != second && first != null && second != null) {
		first = first.parent;
		second = second.parent; 
	}
	// if either is null, no common, therefore return null
	// else we can return one of the two bc they are the same
	return first == null || second == null ? null :  first; 

}


TreeNode goUpBy(TreeNode n, offset) {
	while (offset > 0 && n != null) {
		n = n.parent;
		offset--; 
	}
	return n; 
}

int depth(TreeNode n) {
	int depth = 0; 
	// since we are given the node itself, we have to go up to count depth
	while (n != null) {
		n = n.parent; 
		depth++; 
	}
	return depth; 
}


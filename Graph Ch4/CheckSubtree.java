/* A tree T2 is a subtree of T1 if there exists node n in T1
 * such that the subtree of n is identical to T2 
 */ 


// SIMPLE APPROACH - SUBSTRING 
// PREORDER TRAVERSAL, REPLACING NULL WITH 'X'
boolean containsTree(TreeNode t1, TreeNode t2) {
	StringBuilder s1 = new StringBuilder(); 
	StringBuilder s2 = new StringBuilder(); 

	// convert tree via preorder into a string 
	getOrderString(t1, s1);
	getOrderString(t2, s2);

	// if s2 is substring of s1 then 
	// t2 is subtree of t1 
	return s1.indexOf(s2.toString()) != -1; 
}

void getOrderString(TreeNode node, StringBuilder sb) {
	// for null append
	if (node == null) {
		sb.append("X");
		return; 
	}
	// add root
	sb.append(node.data + " ");
	// add left 
	getOrderString(node.left, sb);
	// add right 
	getOrderString(node.right, sb);	

}



// ALTERNATIVE = search through larger tree
// everytime we have node that matches root of T2 call matchTree
// to check for all rest of subtree to check if identical 


// O(nm) technically correct
// O(n + km) --> we call m (match tree) for every k occurrences of T2's root in T1


boolean containsTree(TreeNode t1, TreeNode t2) {
	if (t2 == null) return true; 
	return subTree(t1, t2);

}

boolean subTree(TreeNode r1, TreeNode r2) {
	if (r1 == null) {
		return false; 
		// if root is same, we call matchTree
	} else if (r1.data == r2.data && matchTree(r1, r2)) {
		return true; 
	}
	// search down the left subtree and right subtree for s2
	return subTree(r1.left, r2) || subTree(r1.right, r2)

}


boolean matchTree(TreeNode r1, TreeNode r2) {

	if (r1 == null && r2 == null) {
		// the roots are both null return 
		return true; 
	} else if (r1 == null || r2 == null) {
		// only one is null, other is not
		return false; 
	} else if (r1.data != r2.data) { // not the same therefore return false
		return false;
	} else {
		// match the subtrees 
		return matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right);
	}




}
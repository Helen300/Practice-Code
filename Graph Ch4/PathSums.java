// BINARY TREE 
// DESIGN ALG THAT COUNTS NUM OF PATHS THAT SUM TO GIVEN VALUE


int countPathsWithSum(TreeNode root, int targetSum) {
	return countPathsWithSum(root, targetSum, 0, new HashMap<Integer, Integer>());
}

int countPathsWithSum(TreeNode node, int targetSum, 
					int runningSum, HashMap<Integer, Integer> pathCount) {

	// BASE CASE
	if (node == null) return 0; 


	/* COUNT PATHS W/ SUM ENDING AT CURRENT NODE */ 
	
	// to get the new running sum 
	runningSum += node.data; 
	// used to find if path of running sum of this sum exists 
	int sum = runningSum - targetSum; 
	// get total paths from hash table for this sum 
	// how many paths have a sum of this which we saw 
	int totalPaths = pathCount.getOrDefault(sum, 0);


	/* IF runningSum == targetSum, one additional path
	   starts at the root, add this path */ 

	if (runningSum == targetSum) {
		totalPaths++; 
	}



	/* INCREMENT pathCount, recurse then decrement pathCount
	 * decrement bc we are done w it */ 
	// increment hash table by one 
	incrementHashTable(pathCount, runningSum, 1);
	// recursing left and right
	totalPaths += countPathsWithSum(node.left, targetSum, runningSum, pathCount);
	totalPaths += countPathsWithSum(node.right, targetSum, runningSum, pathCount);
	// decrement
	incrementHashTable(pathCount, runningsum, -1);

	return totalPaths;
}


void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta) {
	int newCount = hashTable.getOrDefault(key, 0) + delta; 
	// remove if zero to reduce space usage 
	if (newCount == 0) {
		hashTable.remove(key);
	} else {
		hashTable.put(key, newCount);
	}
}

// RUNTIME O(N) - N = num of nodes in the tree
// travel to each node just once, O(1) work
// space = O(log N) due to hash table 
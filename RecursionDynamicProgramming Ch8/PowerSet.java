ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
	// array for all subsets
	ArrayList<ArrayList<Integer>> allsubsets;

	if (set.size() == index) { // Base case - add empty set
	
		allsubsets = new ArrayList<ArrayList<Integer>>();
		allsubsets.add(new ArrayList<Integer>()) // Empty set
	} 

	else {	
		// getting all sets 
		allsubsets = getSubsets(set, index + 1);
		int item = set.get(index);
		ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
		for (ArrayList<Integer> subset : allsubsets) {
			// appending subset
			ArrayList<Integer> newsubset = new ArrayList<Integer>();
			newsubset.addAll(subset); II
			newsubset.add(item);
			moresubsets.add(newsubset);
		}
	allsubsets.addAll(moresubsets);
	}
	return allsubsets;
}
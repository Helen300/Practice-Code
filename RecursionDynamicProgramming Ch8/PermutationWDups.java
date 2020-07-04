// withduplicates
// create only unique permutations


// start by computing count of each letter in given str



ArrayList<String> printPerms(String s) {


	ArrayList<String> result = new ArrayList<String>();
	// counting no of each letter 
	HashMap<Character, Integer> map = buildFreqTable(s);
	// PREFIX INITIALLY EMPTY 
	printPerms(map, "", s.length(), result);
	return result; 

}



HashMap<Character, Integer> buildFreqTable(String s) {
	HashMap<Character, Integer> map = new HashMap<Character, Integer>(); 
	for (char c : s.toCharArray()) {
		// if it doesn't contain the key, add it 
		if (!map.containsKey(c)) {
			map.put(c, 0);
		}
		// update map
		map.put(c, map.get(c) + 1);

	}
	return map; 
}


void printPerms(HashMap<Character, Integer> map, 
				String prefix, int remaining, 
				ArrayList<String> result) {

	// BASE CASE - PERMUTATION DONE
	if (remaining == 0) {
		result.add(prefix);
		return;
	}

	// Try remaining letters for next char
	// generate permutations
	// for all letters involved
	for (Character c : map.keySet()) {
		// get its count
		int count = map.get(c);
		if (count > 0) {
			map.put(c, count - 1);
			// for each call of this count will decrement
			printPerms(map, prefix + c, remaining - 1, result);
			// after done with this one prefix + c and permutation
			// we put it back 
			map.put(c, count);
		}
	}



}

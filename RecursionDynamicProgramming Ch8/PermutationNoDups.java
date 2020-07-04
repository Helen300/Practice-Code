ArrayList<String> getPerms(String str) {
	

	if (str == null) return null; 

	ArrayList<String> permutations = new ArrayList<String>();

	if (str.length() == 0) {
		// base case
		permutations.add("");
		return permutations; 
	}

	// get first char 
	char first = str.charAt(0); 
	// remove first char s
	String remainder = str.substring(1);
	// get all permutations of the remaining set of letters
	ArrayList<String> words = getPerms(remainder);
	// after getting all perms of remainder
	// for each word in set of permutations 
	for (String word : words) {
		for (int j = 0; j <= words.length(); j++) {
			// at every index, insert the first character
			// to get permutations of remainder with char
			String s = insertCharAt(word, first, j);
			// this is what gets returned
			// list of permutations
			permutations.add(s);
		}
	}
	return permutations;
}

// Insert char c at index i in word
String insertCharAt(String word, char c, int i) {

	// get the substring of the word from beginning to i
	String start = word.substring(0,i);
	// get substring of word from i and to the end
	String end = word.substring(i);
	return start + c + end; 
}
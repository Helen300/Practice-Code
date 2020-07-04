// sort array of strings
// make all anagrams next to each other 

// don't actually need to sort entire list
// since sorted in this question just means anagrams are next
// to each other, we can create list of all words mapped to its
// sorted version and then use the list to put them back



class AnagramComparator implements Comparator<String> {

	public String sortChars(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}

	public int compare(String s1, String s2) {
		return sortChars(s1).compareTo(sortChars(s2));
	}

}


void sort(String[] array) {
	HashMapList<String, String> mapList = new HashMapList<String, String>();

	// Group words by anagram
	for (String s : array) {
		String key = sortChars(s); 
		// for that anagram key, put this word as a value
		mapList.put(key, s);
	}

	int index = 0; 
	for (String key : mapList.keySet()) {
		ArrayList<String> list = mapList.get(key);
		for (String t : list) {
			array[index] = t;
			index++;
		}
	}
}
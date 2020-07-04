int search(String[] strings, String str) {

	if (strings == null || str == null || str == "") {
		return -1; 
	}
	search(strings, str, 0, strings.length - 1);


}


int search(String[] strings, String str, int first, int last) {


	if (first > last) return -1; 
	// to the middle 
	int mid = last + first / 2; 

	// if it is empty, find closet non-empty string, meaning
	// we must go both ways to look 
	if (strings[mid].isEmpty()) {

		int left = mid - 1; 
		int right = mid + 1; 
		while (true) {
			if (left < first && right > last) {
				return -1; 
			}
			else if (right <= last && !strings[right].isEmpty()) {
				mid = right; 
				break;
			}
			else if (left >= first && !strings[left].isEmpty()) {
				mid = left; 
				break;
			}
			right++;
			left++;
		}
	}
	// check for string and recurse
	if (str.equals(strings[mid])) {
		// found 
		return mid; 
	}
	else if (strings[mid].comparetO(str) < 0) {
		return search(strings, str, mid + 1, last);
	}
	else {
		return search(strings, str, first, mid - 1);
	}

}
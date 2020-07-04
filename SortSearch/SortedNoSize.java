// find out the length by exponentially guessing



int search(Listy list, int value) {
	int idex = 1; 
	// search for when the end of list
	// as well as making search that the element at that
	// value must be more than in order to break out
	while (list.elementAt(index) != -1 
		&& list.elementAt(index) < value) {
		index *=2; 
	}
	return binarySearch(list, value, index / 2, index);

}

int binarySearch(Listy list, int value, int low, int high) {

	int mid; 
	while (low <= high) {
		mid = (low + high) / 2; 
		int middle = list.elementAt(mid); 
		if (middle > value || middle == -1) {
			high = mid - 1; 
		}
		else if (middle < value) {
			low = mid + 1; 
		}
		else {
			return mid; 
		}
	}
	// not found
	return -1;

}
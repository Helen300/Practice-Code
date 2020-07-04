// 0 1 2
// 0 2 1
// 1 2 0
// 1 0 2
// 2 0 1
// 2 1 0 


// OPERATES IN O(N) TIME

void sortValleyPeak(int[] array) {

	// making the middle element the peak 
	// jumping over two each time
	// so that we have sets of 3 peaks/valleys
	// small <= large <= medium
	// medium <= large <= small
	for (int i = 1; i < array.length; i += 2) {
		// finding the max of the 3 indicies 
		int biggestIndex = maxIndex(array, i - 1, i, i + 1);
		// if not the biggest, we swap i with the adjacent biggest
		if (i != biggestIndex) {
			swap(array, i, biggestIndex);
		}
	}
}

int maxIndex(int[] array, int a, int b, int c) {
	int len = array.length; 
	// VALIDATING INDICIES AND RETURNING WHICHEVER IS SMALLER
	// if invalid index return the smallest num possible
	int aValue = a >= 0 && a < len ? array[a] : Integer.MIN_VALUE;
	int bValue = b >= 0 && b < len ? array[b] : Integer.MIN_VALUE;
	int cValue = c >= 0 && c < len ? array[c] : Integer.MIN_VALUE;

	int max = Math.max(aValue, bValue, cValue);
	if (aValue == max) return a; 
	else if (bValue == max) return b; 
	else return c; 
}

void swap(int[] array, int swapTo, int swapFrom) {

	int temp = array[swapTo];
	array[swapTo] = array[swapFrom];
	array[swapFrom] = temp;


}





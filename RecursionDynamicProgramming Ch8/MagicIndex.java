// BRUTE FORCE - literally iterate through all and check 

int bruteForceMagicIndex(int[] array) {
	int i = 0; 
	while (array[i] != i) {
		i++;
	}
	if (i == 0 && array[0] == 0) {
		return 0; 
	}
	else if (i > 0) {
		return i;
	}
	return -1; 
}


// BINARY SEARCH O(log N) 
// SORTED ARRAY, DISTINCT NUMBERS

int magicFast(int[] array) {
	// start = 0, end = array.length - 1 (last index)
	return magicFast(array, 0, array.length - 1);
}

int magicFast(int[] array, start, end) {
	if (end < start) {
		return -1; 
	}

	int mid = start + end / 2; 
	if (array[mid] == mid) {
		return mid;
	}
	else if (array[mid] > mid) {
		return magicFast(array, start, mid - 1);
	}
	else {
		return magicFast(array, mid + 1, end);
	}

}



// FOR IF NOT DISTINCT INTEGERS IN SORTED ARRAY
int magicFast(int[] array) {
	return magicFast(array, 0, array.length - 1);
 }

int magicFast(int[] array, int start, int end) {
 if (end < start) return -1;

 int midIndex = (start + end ) / 2;
 int midValue = array[midIndex];
 
 if (midValue == midlndex) {
 return midIndex;
 }

 /* Search left recursively*/
 int leftIndex = Math.min(midIndex - 1, midvalue);
 int left = magicFast(array, start, leftIndex);
 if (left >= 0) {
 return left;
 }

 /* Search right recursively*/
 int rightIndex = Math.max(midIndex + 1, midValue);
 int right = magicFast(array, rightIndex, end);

 return right;
 }
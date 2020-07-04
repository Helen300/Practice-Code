// Given set of integers that has been rotated
// find an element in the array
// array was originally sorted in increasing order


// since we kniow that one half of array must be ordered
// we can look at normally ordered half to determine 
// whether to search left or right half



// 1. Given n  to find in the array
// 2. look at array[0] and array[mid]
// 3. if array[0] < array[mid] we know that. left must be ordered
// normally, and check if n falls in bw, if it does, we can
// search left half, else search right half
// 4. if array[0] > array[mid], left is not ordered normally
// then we can check mid and right to see if n falls in bw

int search(int a[], int left, int right, int x) {

	int mid = (left + right) / 2
	if (x == a[mid]) {
		return mid; 
	}
	if (right < left) {
		return -1; 
	}

	// one of the half must be ordered normally, find 
	// out which one it is, then use normal;y ordered
	// half to figure out which side to search to find x

	if (a[left] < a[mid]) { // left side normally
		if (x >= a[left] && x < a[mid]) {
			// in between left and mid 
			return search(a, left, mid - 1, x); // search left
		}
		else {
			// not in bw so search right 
			return search(a, mid + 1, right, x);
		}
	}
	else if (a[left] > a[mid]) { // right side must be normally ordered
		if (x >= a[mid] && x < a[right]) {
			// in between left and mid 
			return search(a, mid + 1, right, x); // search right
		}
		else {
			// not in bw so search left
			return search(a, left, mid - 1, x);
		}
	}
	else if (a[left] == a[mid]) { // DUPLICATES
		// check if right side is different
		if (a[mid] != a[right]) { 
			return search(a, mid + 1, right, x); // search right
		}
		else { // else we must search both halves
			// search left 
			int result = search(a, left, mid - 1, x);
			// did not find on leftside
			if (result == -1) {
				return search(a, mid + 1, right, x);
			}
			// found on left side 
			else {
				return result; 
			}
		}
	}

}
// Given two sorted arrays, A and B, merge them
// A has enough space at the end to hold B



// Basically, merge by starting from the ends 
// if a is bigger, move it to the end, if b is bigger, copy it over



void merge(int[] a , int[] b, int lastA, int lastB) {

	// getting index of last element in array a
	int indexA = lastA - 1; 
	// getting index of last element in array b
	int indexB = lastB - 1; 
	// end of merged array once copied over
	int indexMerged = lastB + lastA - 1;


	while (indexB >= 0) {
		// if still indicies remaining for array A
		// value in A bigger than one in B
		if (indexA >= 0 && a[indexA] > b[indexB]) {
			// copy A into last element
			a[indexMerged] = a[indexA];
			indexA--;
		}
		else {
			// copy from B
			a[indexMerged] = b[indexB];
			indexB--;
		}
		// move indcies
		indexMerged--;

	}


}
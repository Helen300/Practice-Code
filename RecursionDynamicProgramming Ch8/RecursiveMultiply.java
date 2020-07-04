// count half,then double it 
// even vs. odd

// Given two ints a and b, multiple them indirectly 
// can use multiply, add, subtract, bitshift
int minProduct(int a, int b) {

	int big = a < b ? b : a; 
	int small = a < b ? a : b; 
	return minProductHelper(small, big);
}

int minProductHelper(int small, int big) {

	if (small == 0) {
		return 0; 
	}

	else if (small == 1) {
		return big; 
	}

	// divide it by 2 (to get half of the m)
	int s = smaller >> 1; 
	// keep dividing by 2 until == 1  
	int halfProd = minProductHelper(s, big);

	// if even 
	if (smaller % 2 == 0) {
		return halfProd + halfProd;
	}
	else {
		return halfProd + halfProd + big; 
	}

}

// RUNTIME O(log s). - s = smaller of two numbers
// bc we are dividing smaller by 2 every time
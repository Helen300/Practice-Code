// M X N MATRIX
// each row and column are in ascending order


// SOLUTION 1 : NAIVE SOLUTION
// Do binary search on every row
// takes O(M log N) because M rows, and N elements per row



// if start of column > x, then x can't be in that column
// or any of the columns to the right since each column 
// is ordered therefore start of column = minimum


// if start row > x, move upwards


// FINAL OBSERVATIONS:
// 1. if start column > x , x is to left of column 
// 2. if end of column < x , x is to the right of col
// 3. if start of row > x , x is to left of column 
// 4. if end of row < x , x is below that row 


boolean findElement(int[][] matrix, int elem) {
	// starting at 0th row
	// last column 
	int row = 0; 
	int col = matrix[0].length - 1;
	// while we are within bounds 
	while (row < matrix.length && col >= 0) {
		// found it
		if (matrix[row][col] == elem) {
			return true; 
			// keep going in a row 
		} else if (matrix[row][col] > elem) {
			col--; 
			// going down rows 
		} else {
			row++; 
		}
	}

	// did not find it
	return false; 
}

// SOLUTION 2 : BINARY SEARCH

// Coordinate class
// partitionAndSearch
// PG 410
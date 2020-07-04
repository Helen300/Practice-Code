/* GIVEN: 
 * two 32-bit nums N and M
 * two bit positions, i and j 
 */

/* TO DO:
 * write method to insert M into N such that M starts at
 * bit j and ends at bit i
 */


/* ASSUMPTIONS:
 * bits j through i has enough space to fit all of m, BUT POSSIBLY MORE?
 */


/* HINTS:
 * 1. clear appropriate bits in N from i to j 
 * 2. to clear bits, create bit mask 
 * 3. 
 */


// SOLUTION: 
// INSERT M INTO N at bits i to j of n
int updateBits(int n, int m, int i, int j) {

// 1. clear bits j through i in N with bit mask

//  create mask to clear bits i through j in n 
	int allOnes = ~0; // creates sequence of all 1s 11111111

	// 1's before position j, then 0s
	// to make sure that we don't change anything before jth bit
	// J inclusive so j + 1
	// shift allOnes left by j + 1 
	int left = allOnes << ( j + 1)


	// 1's after position i, right shift 
	int right = ((1 << i)) - 1;

	// to get left and right in the same int, just OR them
	int mask = left | right; 

// 2. shift M so that it lines up with bits j through i
	// clear bits j through i in N with the mask 
	int n_cleared = n & mask; 
	// move m into correct position j through ith bits 
	int m_shifted = m << i; 
// 3. Merge M and N
	// OR them to move m shifted into n cleared 
	return n_cleared | m_shifted; 

}
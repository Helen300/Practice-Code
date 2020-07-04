// Using Memoization
// Recursion

// how many paths are there to get to the n-step
// can take 1-step, 2-step, 3-step 
int countWays(int n) { 
	// initialize array for memo of size n + 1 
	int[] memo = new int[n + 1];
	// initialize memo to all 0 
	Arrays.fill(memo, -1);
	countWays(memo, n);


}

int countWays(int[] memo, int n) {
	if (n < 0) {
		// 0 ways to take less than 0 steps or negative 
		return 0; 
	}
	else if (n == 0) {
		return 1; 
	}
	// use cache
	else if (memo[n] != -1) {
		return memo[n];
	}
	// caching values that have already been visited
	else { 
		memo[n] = countWays(n - 3) + countWays(n - 2) + countWays(n - 1);
	}
	return memo[n];
	
}
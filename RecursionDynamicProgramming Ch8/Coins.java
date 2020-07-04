int makeChange(int n) {

	int[] denoms = {25, 10, 5, 1};
	int[][] map = new int[n + 1][denoms.length];
	return makeChange(n, denoms, 0, map);
}


int makeChange(int amt, int[] denoms, int index, 
			   int[][] map) {
	// this amt using a specific center exists already 
	if (map[amt][index] > 0) {
		// return cached value
		// there is some num of ways to do it
		return map[amt][index];
	} 
	// one denom remaining
	if (index >= denoms.length - 1) return 1; 
	int denomAmount = denoms[index];
	int ways = 0; 
	// while the center * i is less than our amount 
	for (int i = 0; i * denomAmount <= amt; i++) {
		int amountRemaining = amt - i * denomAmount; 
		ways += makeChange(amountRemaining, denoms, index + 1, map);
	}
	// set another cache value 
	map[amount][index] = ways; 
	return ways; 



}
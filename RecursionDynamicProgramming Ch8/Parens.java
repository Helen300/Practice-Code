// add left and right parens, as long as expression remains valid

void addParen(ArrayList<String> list, 
			  int leftRem, int rightRem, 
			  char[] str, int index) {

	// if there is less right parentheses remaining than left
	if (leftRem < 0 || rightRem < leftRem) return; 


	if (leftRem == 0 && rightRem == 0) {
		list.add(String.copyValueOf(str));
	}
	else {
		str[index] = '('; // ADD LEFT AND RECURSE
		// at the next index add another ( 
		addParen(list, leftRem - 1, rightRem, str, index + 1);
	
		str[index] = ')'; // ADD RIGHT AND RECURSE
		// at the next index add another )
		addParen(list, leftRem, rightRem - 1, str, index + 1);
	}
}


ArrayList<String> generateParens(int count) {
	// GIVEN COUNT = HOW MANY PAIRS OF PARENTHESES
	// each pair has two one left one right
	char[] str = new char[count * 2];
	ArrayList<String> list = new ArrayList<String>();
	// starting at initial index
	// we know we have count # of left & right parens
	// str = the string we build atm 
	// list = our list of all permutations of parens
	addParen(list, count, count, str, 0);
	return list;
}



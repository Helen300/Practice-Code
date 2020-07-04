// sort a given stack such that smallest items on top
// can use temp stack but may not copy into any other ds
// supports push, pop, peek, isEmpty


/* SOLUTION 
 * we can sort s1 by inserting each element from
 * s1 into s2 in an ordered manner 
 */ 

void sort(Stack<Integer> s) {
	Stack<Integer> r = new Stack<Integer>();
	// while given stack is not empty 
	while (!s.isEmpty()) {
		// pop the next element
		int next = s.pop();
		//// must keep checking if it is less
		// while whats on top is greater than current
		while (!r.isEmpty() && r.peek() > tmp) {
			//. push back onto the stack, the larger ones
			s.push(r.pop())
		}
		r.push(tmp);
	}

	// copy elements from r back to original stack s
	s.push(r.pop());
}

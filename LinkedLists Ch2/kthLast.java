// To Find kth last element of a singly linked list 

// k = 0 (last element)
// k = 1 (last element)
// k = 2 (second to last element)
// k = 3 (third to last element)


// IF SIZE OF LINKED LIST IS KNOWN
// can simply determine how far to go to get to kth last element
// kth last element = (length - k)th element 


// RECURSIVE SOLN
// recurses through linked list
// when hits end, mmethod passes back counter set to 0 
// each parent call adds 1 to this counter 
// when counter = k, we've reached the kth to last element of linked list
// Don't return element, bc need to return index for it to work 
int printKthToLast(LinkedListNode head, int k) {
	// if we've reached the end, we return 0 
	if (head == null) {
		return 0; 
	}
	// each parent call adds 1 to the index 
	int index = printKthToLast(head.next, k) + 1; 
	if (index == k) {
		System.out.println(k + "th to last node is" + head.data) 
	}
	// when we return from each parent call 
	return index; 

}

// if not allowed to print, can create a wrapper class -
// to return counter within simple class via reference 

// SPACE = O(N) bc of recursive calls 


// ITERATIVELY IMPLEMENTATION 
// two pointers p1 and p2
// place them k nodes apart (p2 at beginning and p1 k nodes into list)
// move them incrementally, p1 will hit end of list after Length - k steps
// at this point p2 will be Length - k nodes into list (k nodes from last)


/* RUNTIME = 0(N) TIME BC we must go through entire list at least once */ 
// N + N = O(N)
// SPACE = O(1) extra pointers don't take up extra space
LinkedListNode kthToLast(LinkedListNode head, int k) {
	// two pointers start at head
	LinkedListNode p1 = head;
	LinkedListNode p2 = head;
	int i = 0; 
	// move it k elements into the list 
	// this part may take at worst N bc k could be 0 therefore we must go to the end
	while (i != k) {
		if (p1 == null ) return null; // out of bounds
		p1 = p1.next;
	}

	// now iterate through 
	// this part is also at worst N 
	while (p1 != null) {
		// iterate them one by one 
		p1 = p1.next;
		p2 = p2.next;
	}
	return p2; 

}

/* partition linked list around value x such that all nodes
   less than x come before all nodes greater than or equal to x.
   If x is contained within list, values of x only need to be after 
   elements less than x. Parittion element x can appear anywhere */ 


/* values of the partition can appear anywhere as long as they
   are after all values less than x */ 


// Input 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 (partition = 5)
// Output 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8


/* since we have a linked list, we can simply create
   two linked list, one of after and one before
   then merge the two linked lists at the end */


// we want to return node to partitioned link list
// takes in something not sorted and a partition x
LinkedListNode partition(LinkedListNode node, int x) {

	LinkedListNode beforeStart = null;
	LinkedListNode beforeEnd = null;
	LinkedListNode afterStart = null;
	LinkedListNode afterEnd = null;

	// iterating through the link 
	while (node != null) {
		LinkedListNode next = node.next;
		node.next = null; 

		// for ones less than partition
		if (node.data < x) {
			// insert into end of before list
			// for the first item 
			if (beforeStart == null) {
				beforeStart = node;
				beforeEnd = beforeStart;
			}
			else {
				// set next of current end to be node
				beforeEnd.next = node; 
				// update end
				beforeEnd = node; 
			}
		}

		else {
			if (afterStart == null) {
				afterStart = node;
				afterEnd = beforeStart;
			}
			else {
				afterEnd.next = node; 
				afterEnd = node; 
			}

		}
		// do same thing for the next node 
		node = next; 


	}

	if (beforeStart == null) {
		return afterStart
	}

	// Meerge before and after list 
	beforeEnd.next = afterStart;
	return beforeStart;

}
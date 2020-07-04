// Delete a node in the middle (any node in the middle)
// given only access to that node


// SOLUTION:
// copy data from next node over to current node and then delete it
// must do for all next nodes... 

// given only access to that node
boolean deleteNode(LinkedListNode n) {
	// the node next to it is null or it is null
	if (n == null || n.next == null) {
		// not able to delete it bc it is the last node
		// cannot change or find prev to get rid of last node
		// or it is not a node 
		// may be able to just mark it as a dummy node if cannot delete ... 
		return false
	}
	// get the next, set it
	// do we have to iterate entire list to remove it.... so
	// that would have to be until n = null right... 
	// otherwise we keep getting next, and copying it over ß
	LinkedListNode next = n.next; 
	n.data = next.data;
	n.next = next.next; 
	return true; 

}


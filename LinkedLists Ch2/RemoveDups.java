// Remove Duplicates from a linked list

/* Solution - use a hash map to detect duplicates and remove
them if they are a duplicate  */ 


public class LinkedListNode():
	// next Node (class Node)
	// prev pointer(?) - for double linked
	// value of node 
	LinkedListNode prev;
	LinkedListNode next;
	int data; 


// Given a LinkedListNode n (probably head of linked list)
// USING A BUFFER = HASHSET
/* RUNTIME - has to be O(N) because we must iterate through all notes
   to see whether or not there are duplicates and to remmove them */ 

void RemoveDups(LinkedListNode n) {
	// create a hash table... 
	HashSet<Integer> set = new HashSet<Interger>();
	// setting up a prev node
	LinkedLIstNode prev = null;
	while (n != null) {
		// if already contains this = duplicate
		if (set.contains(n.data)) {
			// change prev next to be the next of current node 
			prev.nesxt = n.next 
		} else {
			// if new, add it to the hash table to check for dupes of this later on
			set.add(n.data)
			// set a new previous
			prev = n 
		}
		// get the next 
		n = n.next;
	}
}
/* RUNTIME - O(N^2) for each element, must iterate through rest.. but space O(N) */ 
// USE TWO POINTERS - 1 ON CURRENT AND 1 THAT ITERATES THROUGH ALL N elements 
void NoBufferRemove(LinkedListNode n) {
	LinkedListNode current = n;
	while (curremt != null) {
		LinkedListNode runner = current;
		while (runner.next != null) {
			if (runner.next.data == current.data) {
				// removes it 
				// for double linked list would have to change prev as well
				runner.next = runner.next.next;
			} else {
				runner = runner.next;
			}
		}
		current = current.next; 
	}

}






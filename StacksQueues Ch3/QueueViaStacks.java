// Implement Queue via two stacks

// need to modify peek and pop to go in reverse order


/* STACK = LIFO
 * peek = looks at item on top (last item added)
 * pop = gets item on top, removes + returns it =
 *
 */



// QUEUE = FIFO 


public class MyQueue<T> {

	Stack<T> stackNewest, stackOldest

	// constructor
	public MyQueue() {
		stackNewest = new Stack<T>();
		stackOldest = new Stack<T>();
	}

	public int size() {
		return stackNewest.size() + stackOldest.size();
	}


	public void add(T value) {
		// always push onto stackNewest
		// newest elements on top
		stackNewest.push(value);
	}

	// Move elements from stackNewest --> stackOldest 

	public void shiftStacks() {
		// if oldest has nothing 
		// ONLY SHIFTS IF stackOldest is empty
		// if stack oldest is currently not empty
		// don't need to shift bc we still have
		// older elements 
		if (stackOldest.isEmpty()) {
			// while it is empty in stack newest
			while (!stackNewest.isEmpty()) {
				// shift all the elements over
				// pop all from newest
				// push onto oldest 
				stackOldest.push(stackNewest.pop());
			}
		}
	}


	public T peek() {
		// ensure stackOldest has current elements
		shiftStacks();
		// retrieve oldest which should be at top
		return stackOldest.peek(); 
	}

	public T remove() {
		// make sure we are at the oldest 
		shiftStacks();
		return stackOldest.pop();
	}

}
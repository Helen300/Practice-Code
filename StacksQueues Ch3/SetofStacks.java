


class SetOfStacks {
	// get an array list to keep track of all stacks 
	ArrayList<Stack> setStacks = new ArrayList<Stack>();
	// might not even need this, just set size of setStacks
	private int currentStack; 
	public int capacity; 


	public SetOfStacks(int capacity) {
		// initialize currentStack = 0 
		// initialize capacity = capacity
	}

	public void push(int v) {
		// check if our current stack had reached full capacity


		// if not push onto here 


		// if yes, increment a current stack count

		// push onto the new stack




	}



	public void pop() {

		// we should have a current stack count


		// check if that current stack has reached len items = 0 
		// or if current stack = isEmpty


		// if empty, we decrement our current stack count


		// pop off from next stack

		
	}



	public int popAt(int index) {
		return leftShift(index, true); 
	}



	public int leftShift(int index, boolean removeTop) {
		// get stack given index to pop from
		Stack stack = setStacks.get(index);
		int removed_item;
		// direct pop 
		if (removedTop) removed_item = stack.pop();
		else removed_item = stack.removeBottom();

		if (stack.isEmpty()) {
			stacks.remove(index);
		} else if (stacks.size() > index + 1) {
			int v = leftShift(index + 1, false);
			stack.push(v); 
		}

		return removed_item;
	}



	// implement a stack class 

	public class Stack {

		private int capacity; 
		public Node top, bottom; 
		public int size = 0; 


		public Stack(int capacity) { this.capacity = capacity; }

		public boolean isFull() { return capacity == size; }

		public boolean push(int v) {


		}

		public int pop() {

		}

		public boolean isEmpty() {

		}

		public int removeBottom() {

			
		}


	}

}
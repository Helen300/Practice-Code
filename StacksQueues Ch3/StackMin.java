// Implement a Min Stack with PUSH, POP, MIN = O(1)

// Keep track of minimum at each state
// PROBLEM - KEEPING TRACK OF min for every element is alot 
// A LOT OF SPACE WASTED
// extends means must contain class def NodeWithMin
public class StackWithMin extends Stack<NodeWithMin> {


	public void push(int value) {
		// determine what is the new min for new item pushed 
		int newMin = Math.min(value, min())
		// push a node with local min to stack
		super.push(new NodeWithMin(value, newMin));
	}
	public int min() {
		if (this.isEmpty()) {
			return Interger.MAX_VALUE;
		} else {
			// get node from stack and its local min
			return peek().min;
		}
	}

	class NodeWithMin {
		public int value;
		public int min; 
		public NodeWithiMin(int v, int min) {
			value = v; 
			this.min = min; 
		}
	}

}


// USE AN ADDITIONAL STACK THAT KEEPS TRACK OF MINS
// MORE SPACE EFFICIENT
public class StackWithMin2 extends Stack<Integer> {

	Stack<Integer> s2;
	public StackWithMin2() {
		s2 = new Stack<Integer>();
	}

	public void push(int value) {
		// if it is less than the min
		if (value <= min()) {
			// add this to the minimum stack 
			s2.push(value);
		}
		// push this to our elements stack 
		super.push(value);
	}

	public Integer pop() {
		// pop from our elements stack 
		int value = super.pop()
		// if value popped off == top of min, remove it
		if (value == min()) {
			s2.pop();
		}
		return value; 

	}

	public int min() {
		if (s2.isEmpty()) {
			return Interger.MAX_VALUE;
		} else {
			// get top of this stack
			return s2.peek();
		}
	}

}
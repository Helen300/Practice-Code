/* BASE CASE 
 * if (n <= 0) return; 
 */ 

/* move top n - 1 disks from origin to buffer, 
 * using destination as buffer 
 * moveDisks(n-1, origin, buffer, destination);
 */

/* move top from origin to destination 
 * moveTop(origin, destination)
 */ 


/* move top n - 1 disk from buffer to destination, using
 * origin as buffer 
 * moveDisk(n - 1, buffer, destination, origin)
 */ 


void main(String[] args) {
	int n = 3; 
	Tower[] towers = new Tower[n];
	// initializing the three towers
	for (int i = 0; i < 3; i++) {
		towers[i] = new Tower(i);
	}
	// for num of disks, add them to the first tower
	for (int i = n - 1; i >= 0; i--) {
		towers[0].add(i);
	}
	// DESTINATION = TOWER[2]
	// BUFFER = TOWER[1]
	towers[0].moveDisk(n, towers[2], towers[1])
}


class Tower {
	// each tower itself is a stack 
	private Stack<Integer> disks;
	private int index;
	public Tower(int i) {
		disks = new Stack<Integer>();
		index = i; 
	}

	public int index() {
		return index; 
	}

	public void add(int d) {
		if (!disks.isEmpty() && disks.peek() <= d) {
			System.out.println("Error placing disk" + d);
		} else {
			disks.push(d); 
		}
	}


	public void moveTopTo(Tower t) {
		int top = disks.pop();
		t.add(top); 
	}

	public void moveDisks(int n, Tower destination, Tower buffer)  {
		if (n > 0) {
			// move top n - 1 to our buffer as destination and using
			// destination as a buffer 
			moveDisks(n - 1, buffer, destination);
			// move top to destination 
			moveTopTo(destination);
			// using this current tower as a buffer
			// call the moving of buffer as new origin
			buffer.moveDisks(n-1, destination, this);

		}
	}

}

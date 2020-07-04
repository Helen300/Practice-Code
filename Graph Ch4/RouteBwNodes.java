/* Given DIRECTED GRAPH, design alg to find whether there is a path
 * bw two nodes */ 


 // BFS 

enum State { Unvisited, Visited, Visting ;}


boolean search(Graph g, Node start, Node end) {
	// meaning starting node = ending node 
	if (start == end) return true;

	// operates as Queue
	// state of all nodes that are VISITING
	LinkedList<Node> q = new LinkedList<Node>();

	// for all nodes in graph g, mark them as initially not visited
	for (Node u : g.getNodes()) {
		u.state = State.Unvisited
	}

	// from our starting point, we set its state to visting
	start.state = State.Visting;

	// to our queue, we add start
	// to set up nodes that we need to visit
	q.add(start);
	Node u; 
	while (!q.isEmpty()) {
		// get a node from our queue, meaning we have not visited
		// dequeue()
		u = q.removeFirst();
		// if dequeued node is not null
		if (u != null) {
			for (Node v : u.getAdjacent()) {
				if (v.state == State.Univisited) {
					if (v == end) {
						// if v = end, means there is a route bw them
						return true; 
					} else {
						// add all adjacent not equal to end
						// to the queue
						v.state = State.Visting;
						q.add(v);
					}
				}
			}
			// mark as visited 
			u.state = State.Visited
		}
	}


}
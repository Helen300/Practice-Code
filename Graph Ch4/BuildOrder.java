/* Given 
 * - list of projects
 * - list of dependencies 
 * - second project dependent on first project (a, b) = b depends on a
 * - all dependencies must be built before the project is
 */ 

// Q: FIND BUILD ORDER THAT WILL LLOW PROJECTS TO BE BUILT, if no valid, return error



// SOLUTION # 1 - TOPOLOGICAL SORT ALGORITHM (PG. 632)
// 1. add nodes w/ no incoming edges, no dependencies 


// 2. remove edges all outgoing edges from these roots

// 3. find new nodes with no incoming edges, remove their outgoing edges

// 4. repeat


// 5. if there are nodes remaining, but all have dependencies
// or incoming edges


// 6. no way to build the system, return an error 


// INITIALIZATION + SETUP

/* 1. Build graph where each project = node, outgoing nodes 
 * represent projects that depend on it, A -> B means that 
 * B depends on A, A must be built before B */ 

Graph buildGraph(String[] projects, String[][] dependencies) {
	Graph graph = new Graph(); 
	for (String project : projects) {
		// for each project, we want to create the node first 
		graph.createNode(project);
	}
	// for all dependencies, create an edge from first -> second 
	for (String[] dependency : dependencies) {
		String first = dependency[0];
		String second = dependency[1];
		// second depends on first, first must be made first 
		graph.addEdge(first, second);
	}
	return graphl 
}


/* 2. When we determine project's build order, we can add it to 
 * a buildOrder array */


 /* 3. To find all nodes with zero incoming edges, add those to 
  * buildOrder array and toBeProcessed pointer to beginning of array 
  */

 /* 4. Repeat until toBeProcessed is at end of buildOrder:
    a. Re node at toBeProcessed, if null - remaining nodes all have 
       dependencies meaning that we have an error (cycle)
    b. For each child of node, decrement child (num of dependencies)
       if child.dependencies == 0, add it to end of buildOrder 
    c. Increment toBeProcessed */




// RETURN LIST OF PROJECTS a correct build order
 Project[] orderProjects(ArrayList<Project> projects) {
 	Project[] buildOrder = new Project[projects.size()];

 	// add roots to the buildOrder array first 
 	// from list of projects, add 
 	int endOfList = addNonDependent(buildOrder, projects, 0);

 	// still must process all projects
 	int toBeProcessed = 0; 
 	while (toBeProcessed < order.length) {
 		Project current = order[toBeProcessed];
 		// circular dependency bc no remaining projects w/ 
 		// zero dependencies 
 		// which is BAD --> ERROR 
 		if (current == null) {
 			return null; 
 		}
 		ArrayList<Project> children = current.getChildren(); 
 		// remove current as a dependency from each child 
 		for (Project child : children) {
 			child.decrementDependencies(); 
 		}

 		// Add children that have zero dependncies 
 		// current end of list in buildOrder (keeping track)
 		endOfList = addNonDependent(buildOrder, children, endOfList)
 		toBeProcessed++;
 	}
 	return order; 
 }



// HELPER FUNCTION TO INSERT PROJECTS W/ ZERO DEPENDENCIES 
// INTO buildOrder Array, starting at index offset 
 int addNonDependent(Project[] order, ArrayList<Project> projects, int offset) {
 	// for all projects, if project dependency == 0 
 	// insert them into the beginning of order array 
 	for (Project project : projects) {
 		if (project.getNumberDependencies() == 0) {
 			order[offset] = project;
 			offset++; 
 		}
 	}
 	// return our current offset for buildOrder
 	return offset; 
 }
// runtime O(P + D) where P = num of projects, D = num dependencies

// PROJECT AND GRAPH CLASSES PG. 254




///////////////// ///////////////// ///////////////// /////////////////
///////////////// ///////////////// ///////////////// /////////////////
///////////////// ///////////////// ///////////////// /////////////////
///////////////// ///////////////// ///////////////// /////////////////
///////////////// ///////////////// ///////////////// /////////////////


 // SOLUTION 2 - DFS TO FIND BUILD PATH
 // PICKING AN ARBITRARY NODE TO START ON
 // Cycle - if while processing, we see node again
 // keeping track of states

 Stack<Project> findBuildOrder(String[] projects, String[][] dependencies) {
 	Graph graph = buildGraph(projects, dependencies);
 	return orderProjects(graph.getNodes());
 }


// THREE STATES FOR THIS - COMPLETED, PARTIAL, BLANK

 Stack<Project> orderProjects(ArrayList<Project> projects) {
 	Stack<Project> stack = new Stack<Project>();
 	for (Project project : projects) {
 		if (project.getState() == Project.State.BLANK) {
 			// do DFS FOR THIS NODE
 			if (!doDFS(project, stack)) {
 				return null; 
 			}
 		}
 	}
 	return stack; 
 }


 boolean doDFS(Project project, Stack<Project> stack) {
 	if (project.getState() == Project.State.PARTIAL) {
 		return false; // WE'VE ENCOUNTERED A CYCLE
 	}
 	// if project has not yet been processed 
 	if (project.getState() == Project.State.BLANK) {
 		// process it 
 		project.setState(Project.State.PARTIAL);
 		// get all of its children 
 		ArrayList<Project> children = project.getChildren(); 
 		// run dfs 
 		for (Project child : children) {
 			if (!doDFS(child, stack)) {
 				return false; 
 			}
 		}
 		project.setState(Project.State.COMPLETE);
 		stack.push(project);
 	}
 	return true; 
 }


 // RUNTIME O(P + D) where P = num projects, D = num dependency pairs
package Data_Structures;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;

//implementation of graphs using adjacency lists
//this is an undirected graph

public class graph {

	private HashMap<vertex, ArrayList<vertex>> graph = new HashMap<>();

	public void addNode(vertex n) {
		graph.putIfAbsent(n, new ArrayList<>());
	}

	public void removeNode(vertex n) {
		Iterator<vertex> itr = graph.keySet().iterator();

		while(itr.hasNext()) {
			if(itr.next() == n) {
				itr.remove();
			}
		}

		//need some more code to implement the deletion of
		//the orphan edges from each vertex also.....
	}

	public void addEdge(vertex n, vertex des) {
		graph.get(n).add(des);
	}

	public void removeEdge(vertex src, vertex des) {
		if(!graph.get(src).isEmpty()) 
			graph.get(src).forEach((n) -> remove(n, des));
		else
			System.out.println("Vertex " + src.getVertexName() + " doesn't exist.");
	}

	private void remove(vertex n, vertex des) {
		if(n == des)
			n = null;
	}

	public void printGraph() {
		graph.forEach((v, n) -> printVertices(v, n));
	}

	private void printVertices(vertex v, ArrayList<vertex> n) {
		System.out.print(v.getVertexName() + "->");
		Iterator<vertex> itr = n.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next().getVertexName() + " ");
		}
		System.out.println();
	}
}
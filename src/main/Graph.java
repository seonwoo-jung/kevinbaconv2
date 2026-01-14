package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Graph<E, T> {
	private Map<E, Vertex> vertices;
	/*
	 * We need a data structure to hold our data as an instance
	 * Requirements:
	 *      Should be unit time to retrieve and item for starting a traverse
	 *      You don't want to allow duplicate vertices
	 */

	public Graph() {
		//constructor for your graph:
		vertices = new HashMap<>();
	}

	// INNER CLASSES
	//      inner classes all you to have objects for the class that are only accessible to this class
	//      You can't create an edge or a vertex outside of Graph, but get the full OOP functionality
	//      within this class.
	// Edges and Vertices
	private class Edge {
		//your code here:
		T label;
		Vertex endpoint;

		Edge(T label, Vertex endpoint) {
			this.label = label;
			this.endpoint = endpoint;
		}
	}

	private class Vertex {
		//your code here:
		E info;
		ArrayList<Edge> edges;

		Vertex(E info) {
			this.info = info;
			this.edges = new ArrayList<>();
		}
	}

	// Graph Methods:
	// ... what do we need? what actions do we need to take to make/read a Graph?
	//
	public void addVertex(E info) {
		if (!vertices.containsKey(info)) {
			vertices.put(info, new Vertex(info));
		}
	}

	public void connect(E info1, E info2, T label) {
		Vertex v1 = vertices.get(info1);
		Vertex v2 = vertices.get(info2);
		if (v1 == null || v2 == null)
			return;
		// undirected graph - add edge both ways
		v1.edges.add(new Edge(label, v2));
		v2.edges.add(new Edge(label, v1));
	}

	/**
	 * BFS used a Breadth First Search algorithm to find the the shortest path
	 * between 2 vertices in a graph
	 *
	 * @param start
	 * @param target
	 * @return and arraylist containing the path to follow to from start to Target
	 */
	public ArrayList<Object> BFS(E start, E target) {
		Vertex startV = vertices.get(start);
		Vertex targetV = vertices.get(target);
		if (startV == null || targetV == null)
			return null;

		// leadsTo maps each vertex to the edge that led to it
		HashMap<Vertex, Edge> leadsTo = new HashMap<>();
		Queue<Vertex> queue = new LinkedList<>();

		queue.add(startV);
		leadsTo.put(startV, null); // mark as visited, no edge leads to start

		while (!queue.isEmpty()) {
			Vertex current = queue.poll();

			if (current == targetV) {
				return backtrace(targetV, leadsTo);
			}

			for (Edge e : current.edges) {
				if (!leadsTo.containsKey(e.endpoint)) {
					leadsTo.put(e.endpoint, e);
					queue.add(e.endpoint);
				}
			}
		}
		return null; // no path found
	}

	/**
	 * Backtrace is use by other methods to create the path once the target is found.
	 * Each other method is searching the Graph in a specific way, once you get where you need to go
	 * you need to know how you got there, Backtrace is intended
	 *
	 * @param target
	 * @param leadsTo
	 * @return
	 */
	private ArrayList<Object> backtrace(Vertex target, HashMap<Vertex, Edge> leadsTo) {
		ArrayList<Object> path = new ArrayList<>();
		Vertex current = target;

		// build path backwards
		while (leadsTo.get(current) != null) {
			Edge e = leadsTo.get(current);
			path.add(0, current.info);
			path.add(0, e.label);

			// find previous vertex (the one that has edge e pointing to current)
			for (Vertex v : leadsTo.keySet()) {
				for (Edge edge : v.edges) {
					if (edge.label.equals(e.label) && edge.endpoint == current) {
						current = v;
						break;
					}
				}
				if (current != target && leadsTo.get(current) != e)
					break;

			}

		}
		path.add(0, current.info); // add start vertex
		return path;
	}

	/**
	 * Finds the path to the furthest node form the start node.  This is NOT the longest path
	 * from start.  This method returns the node that is farthest away with an efficient path.
	 *
	 * @param start
	 * @return
	 */
	public ArrayList<Object> furthest(E start) {
		Vertex startV = vertices.get(start);
		if (startV == null)
			return null;
		HashMap<Vertex, Edge> leadsTo = new HashMap<>();
		Queue<Vertex> queue = new LinkedList<>();
		Vertex furthestV = startV;

		queue.add(startV);
		leadsTo.put(startV, null);

		while (!queue.isEmpty()) {
			Vertex current = queue.poll();
			furthestV = current; // last one visited is furthest

			for (Edge e : current.edges) {
				if (!leadsTo.containsKey(e.endpoint)) {
					leadsTo.put(e.endpoint, e);
					queue.add(e.endpoint);
				}
			}
		}
		return backtrace(furthestV, leadsTo);
	}

	/**
	 * Find the the vertex with the most edges shared with "start" vertex.
	 * This does not look at ALL vertices to find the most edges, just the most
	 * shared for "start" vertex
	 *
	 * @param start
	 * @return the list of vertices shared between start ad the most common neighbor.
	 * IMPORTANT: The value at index 0 will be the info of the vertex, all other indices will be the
	 * labels of the edges connecting the two vertices.
	 */
	public ArrayList<Object> mostEdgesBetween(E start) {
		Vertex startV = vertices.get(start);
		if (startV == null)
			return null;
		// count edges to each neighbor
		HashMap<Vertex, ArrayList<T>> edgeCounts = new HashMap<>();
		for (Edge e : startV.edges) {
			if (!edgeCounts.containsKey(e.endpoint)) {
				edgeCounts.put(e.endpoint, new ArrayList<>());
			}
			edgeCounts.get(e.endpoint).add(e.label);
		}

		// find vertex with most edges
		Vertex mostEdgesV = null;
		int maxEdges = 0;
		for (Vertex v : edgeCounts.keySet()) {
			if (edgeCounts.get(v).size() > maxEdges) {
				maxEdges = edgeCounts.get(v).size();
				mostEdgesV = v;
			}
		}

		if (mostEdgesV == null)
			return null;

		ArrayList<Object> result = new ArrayList<>();
		result.add(startV.info);
		for (T label : edgeCounts.get(mostEdgesV)) {
			result.add(label);
		}
		result.add(mostEdgesV.info);
		return result;
	}

	/**
	 * Average connectivity calculates the average distance of all reachable nodes from "start" node
	 *
	 * @param start
	 * @return
	 */
	public double averageConnectivity(E start) {
		Vertex startV = vertices.get(start);
		if (startV == null)
			return 0.0;

		HashMap<Vertex, Integer> distances = new HashMap<>();
		Queue<Vertex> queue = new LinkedList<>();

		queue.add(startV);
		distances.put(startV, 0);

		while (!queue.isEmpty()) {
			Vertex current = queue.poll();
			int dist = distances.get(current);

			for (Edge e : current.edges) {
				if (!distances.containsKey(e.endpoint)) {
					distances.put(e.endpoint, dist + 1);
					queue.add(e.endpoint);
				}
			}
		}

		// calculate average (exclude start vertex)
		int total = 0;
		int count = 0;
		for (Vertex v : distances.keySet()) {
			if (v != startV) {
				total += distances.get(v);
				count++;
			}
		}
		if (count == 0)
			return 0.0;

		return Math.round((double)total / count * 100.0) / 100.0;
	}
}

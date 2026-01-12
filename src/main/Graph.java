package main;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph<E, T> {
         
    /*
    * We need a data structure to hold our data as an instance
    * Requirements:
    *      Should be unit time to retrieve and item for starting a traverse
    *      You don't want to allow duplicate vertices
    */

    public Graph(){
        //constructor for your graph:
    }

    // INNER CLASSES
    //      inner classes all you to have objects for the class that are only accessible to this class
    //      You can't create an edge or a vertex outside of Graph, but get the full OOP functionality
    //      within this class.
    // Edges and Vertices
    private class Edge { 
        //your code here:  
    }

    private class Vertex {
        //your code here:  

    }
    


    // Graph Methods:
    // ... what do we need? what actions do we need to take to make/read a Graph? 
    //

    

     /**
     * BFS used a Breadth First Search algorithm to find the the shortest path
     * between 2 vertices in a graph
     * 
     * @param start
     * @param target
     * @return and arraylist containing the path to follow to from start to Target
     */
    public ArrayList<Object> BFS(E start, E target) {
    }

    /**
     * Backtrace is use by other methods to create the path once the target is found.  
     * Each other method is searching the Graph in a specific way, once you get where you need to go
     * you need to know how you got there, Backtrace is intended 
     * @param target
     * @param leadsTo
     * @return
     */
    private ArrayList<Object> backtrace(Vertex target, HashMap<Vertex, Edge> leadsTo) {}

    /**
     * Finds the path to the furthest node form the start node.  This is NOT the longest path
     * from start.  This method returns the node that is farthest away with an efficient path.
     * @param start
     * @return
     */
    public ArrayList<Object> furthest(E start) {}

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
    public ArrayList<Object> mostEdgesBetween(E start) {}

    /**
     * Average connectivity calculates the average distance of all reachable nodes from "start" node
     * 
     * @param start
     * @return
     */
    public double averageConnectivity(E start) {}
}

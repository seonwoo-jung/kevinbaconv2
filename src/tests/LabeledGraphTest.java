package tests;

import java.util.ArrayList;

import main.Graph;

// Test cases for the LabeledGraph class
public class LabeledGraphTest {

    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        testBFS();

        // enable these if you want them:
        // testFurthest();
        // testAverageConnectivity();
        // testMostEdgesBetween();
    }

    public static void testBFS() {
        System.out.println(TEXT_BLUE+"<*** Testing BFS ***>" +ANSI_RESET);
        Graph<String, String> graph = new Graph<>();

        // Add vertices
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        // Connect vertices
        graph.connect("A", "B", "AB");
        graph.connect("A", "C", "AC");
        graph.connect("B", "D", "BD");
        graph.connect("D", "E", "DE");

        // Test BFS from A to E
        ArrayList<Object> expectedPath = new ArrayList<>();
        expectedPath.add("A");
        expectedPath.add("AB");
        expectedPath.add("B");
        expectedPath.add("BD");
        expectedPath.add("D");
        expectedPath.add("DE");
        expectedPath.add("E");

        ArrayList<Object> actualPath = graph.BFS("A", "E");

        Testing.testEquals("BFS from A to E",  actualPath, expectedPath);

        // Test BFS from A to C
        expectedPath.clear();
        expectedPath.add("A");
        expectedPath.add("AC");
        expectedPath.add("C");

        actualPath = graph.BFS("A", "C");

        Testing.testEquals("BFS from A to C", actualPath, expectedPath);

        // Test BFS from B to E
        expectedPath.clear();
        expectedPath.add("B");
        expectedPath.add("BD");
        expectedPath.add("D");
        expectedPath.add("DE");
        expectedPath.add("E");

        actualPath = graph.BFS("B", "E");

        Testing.testEquals("BFS from B to E", actualPath,expectedPath );

        // Test BFS with non-existent vertex
        actualPath = graph.BFS("A", "Z");

        Testing.testEquals("BFS with non-existent vertex", actualPath, null);
    }

    public static void testFurthest() {
        System.out.println(TEXT_BLUE + "<*** Testing Furthest ***>" +ANSI_RESET);
        Graph<String, Integer> graph = new Graph<>();

        // Add vertices and edges to the graph
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.connect("A", "B", 1);
        graph.connect("B", "C", 2);
        graph.connect("A", "D", 3);
        graph.connect("D", "C", 4);
        graph.connect("C", "E", 5);

        // Test BFS from A to E
        ArrayList<Object> expectedPath = new ArrayList<>();
        expectedPath.add("A");
        expectedPath.add(3);
        expectedPath.add("D");
        expectedPath.add(4);
        expectedPath.add("C");
        expectedPath.add(5);
        expectedPath.add("E");

        // Test furthest from A
        ArrayList<Object> furthestVertex = graph.furthest("A");
        Testing.testEquals("Furthest vertex from A should be E", furthestVertex, expectedPath);
    }

    public static void testAverageConnectivity() {
        System.out.println(TEXT_BLUE + "<*** Testing Average Connectivity ***>" +ANSI_RESET);
        Graph<String, Integer> graph = new Graph<>();

        // Add vertices and edges to the graph
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.connect("A", "B", 1);
        graph.connect("B", "C", 2);
        graph.connect("A", "D", 3);
        graph.connect("D", "C", 4);

        // Test average connectivity
        double avgConnectivity = graph.averageConnectivity("A");
        Testing.testEqualsDouble("Average connectivity should be 2.0", avgConnectivity, 1.33, .001 );
    }

    public static void testMostEdgesBetween() {
        System.out.println(TEXT_BLUE + "<*** Testing Most Edges Between ***>" + ANSI_RESET);
        Graph<String, Integer> graph = new Graph<>();

        // Add vertices and edges to the graph
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.connect("A", "B", 1);
        graph.connect("B", "C", 2);
        graph.connect("A", "D", 3);
        graph.connect("D", "C", 4);
        graph.connect("C", "E", 5);
        graph.connect("B", "E", 6);
        graph.connect("A", "E", 7);

        // Test most edges between A and E
        ArrayList<Object> expectedPath = new ArrayList<>();
        expectedPath.add("A");
        expectedPath.add(1);
        expectedPath.add("B");
        expectedPath.add(6);
        expectedPath.add("E");

        ArrayList<Object> actualPath = graph.mostEdgesBetween("A");

        Testing.testEquals("Most edges between A and E", actualPath, expectedPath);

        // Test most edges between A and C
        expectedPath.clear();
        expectedPath.add("A");
        expectedPath.add(3);
        expectedPath.add("D");
        expectedPath.add(4);
        expectedPath.add("C");

        actualPath = graph.mostEdgesBetween("A");

        Testing.testEquals("Most edges between A and C", actualPath, expectedPath);

        // Test most edges between B and D
        expectedPath.clear();
        expectedPath.add("B");
        expectedPath.add(2);
        expectedPath.add("C");
        expectedPath.add(4);
        expectedPath.add("D");

        actualPath = graph.mostEdgesBetween("B");

        Testing.testEquals("Most edges for B ", actualPath, expectedPath);

        // Test most edges between non-existent vertices
        actualPath = graph.mostEdgesBetween("X");

        Testing.testEquals("Most edges between non-existent vertices", actualPath, null);
    }

}
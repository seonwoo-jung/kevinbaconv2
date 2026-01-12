# Kevin Bacon Project

The goal of this project is to create your own version of the "Six Degrees of Kevin Bacon" game. You will build a system that can find the shortest path between any two actors in a massive movie database.

## Learning Outcomes
By the end of this project, you will be able to:
- **Graph Mastery**: Declare, initialize, traverse, and modify complex Graph data structures.
- **Data Persistence**: Load and parse large persistent datasets from files into optimized data structures.
- **Algorithm Design**: Apply graph theory knowledge to implement complex features and algorithms.
- **Critical Thinking**: Evaluate and select the most efficient data structure for a given algorithmic goal.

## Academic Integrity & AI Policy
This project is divided into specific sections with different rules regarding AI assistance (LLMs, Copilot, etc.). Read these carefully.

- **NO AI**: You must implement the logic entirely on your own. Using AI for these sections is a violation of academic integrity.
- **AI ASSISTED**: You may use AI tools to assist with boilerplate, UI styling, or debugging.

**Acknowledgements**
You **MUST** have an Acknowledgements section at the top of the KevinBacon.java file. This section should list any resources you used to complete the project. This includes any websites, books, peers, or other resources you used to complete the project. You should also list any people you worked with on the project. Not having this well impact your grade.

## Project Timeline & Milestones

1. **Graph Implementation**: A one-on-one technical review of your graph implementation
2. **Mid-project Check-in**: A scheduled meeting to review your progress and codebase
3. **Graph Quiz**: A quiz on graph theory and traversal algorithms will be held in class on the final project due date.

## Student Requirements

### 1. Labeled Graph Library | NO AI
You are responsible for writing your own labeled graph library from scratch.  Create the necessary classes and methods to support vertices, and directed/undirected edges labeled with movie titles. You may use the provided `LabeledGraphTest.java` to verify your implementation.
> **<span style="color:red">This is a NO AI portion of this project.</span>**

### 2. Data Import & Modeling | NO AI
Write an algorithm to import the provided data files (`actors`, `movie-actors`, `movies` or `movies_metadata`) into appropriate data structures.  Use the graph you created in the previous step to store the relationships between actors and movies.  You will need to devise a strategy to connect these disparate data points into your graph representation.  You may use the provided `DataLoaderTest.java` to verify your implementation.
> **<span style="color:red">This is a NO AI portion of this project.</span>**

> #### 2.1 Data Import Test | AI ASSISTED
> Use AI to write test import data and a test file like we have for the Graph library. Use the test files to verify your implementation. Try to think of edge cases and added test data to verify your implementation.
> **<span style="color:green">You may use AI to help you with this portion of the project.</span>**


### 3. Shortest Path Search (BFS) | NO AI
Implement a Breadth-First Search (BFS) algorithm to find the shortest connection between any two actors.  This implementation includes a predecessor map so you can output the "Bacon Number" and the specific sequence of movies/actors in the path.
> **<span style="color:red">This is a NO AI portion of this project.</span>**

### 4. Other Search Capabilities | NO AI
Extend your search capabilities by creating each of the following:
- A filtered BFS.  The `movies_metadata.csv` file contains additional information about each movie, including its Bechdel_score, release year, and genre.  Create a feature that allows the user to filter the search results based on the user's preferences based on at least one of these data points.
- Average Connectivity 
- Most Edges Between
- Furthest Node
> **<span style="color:red">This is a NO AI portion of this project.</span>**

### 5. Extra Functionality | NO AI
Implement at least one additional feature. Examples include, but you are not limited to:
- Finding the "Center of the Hollywood Universe" (lowest average Bacon number).
- Implement Dijkstra's algorithm to find the shortest path between two actors based on a value on the edge.  BFS finds the shortest path in terms of number of edges, but Dijkstra's finds the shortest path in terms of a value on the edge.
- Further integration with enriched movie metadata (Bechdel ratings, genres, etc.).
> **<span style="color:red">This is a NO AI portion of this project.</span>**

### 6. GUI Implementation | AI ASSISTED
Build a user-friendly interface to tie everything together.
- **Features**: Enter actor names, view paths, handle "break" cases (misspellings/no path), and interact with extra features.
> **<span style="color:green">You may use AI to help you with this portion of the project.</span>**

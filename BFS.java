import java.util.*;

public class BFS {
    // Graph represented as an adjacency list

    private Map<Integer, List<Integer>> graph;
    public BFS(Map<Integer, List<Integer>> graph) {
        this.graph = graph; // Initialize the graph
    }

    public List<Integer> bfs(int startNode) {
        // List to store visited nodes
        List<Integer> visited = new ArrayList<>();
        // Queue to store nodes for BFS
        Queue<Integer> queue = new LinkedList<>();

        visited.add(startNode); // Mark the start node as visited
        queue.add(startNode); // Add the start node to the queue

        while (!queue.isEmpty()) {
            int node = queue.poll(); // Get the next node from the queue
            // Print the visited node
            System.out.print(node + " ");
            // Get the neighbors of the current node
            List<Integer> neighbors = graph.getOrDefault(node, new
                    ArrayList<>());
            for (int neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor); // Mark the neighbor as visited
                    queue.add(neighbor); // Add the neighbor to the queue
                    // for further exploration
                }
            }
        }

        return visited; // Return the list of visited nodes
    }

    public static void main(String[] args) {
        // Creating a graph represented as an adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(2));
        graph.put(2, Arrays.asList(0, 3));
        graph.put(3, Arrays.asList(3, 4));

        int startNode = 2; // Choose the starting node for BFS

        BFS bfs = new BFS(graph); // Create an instance of BFS
        // Perform BFS starting from the specified node

        List<Integer> visitedNodes = bfs.bfs(startNode);
        System.out.println("\nVisited Nodes: " + visitedNodes);
    }
}


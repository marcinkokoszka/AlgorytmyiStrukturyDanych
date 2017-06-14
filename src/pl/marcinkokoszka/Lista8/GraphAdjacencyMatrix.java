package pl.marcinkokoszka.Lista8;

import java.util.*;

//Zadanie 2 - macierz sąsiedztwa - nieskierowany - wyszukiwanie minimalnego drzewa rozpinającego
//Zadanie 3
public class GraphAdjacencyMatrix {
    public Node rootNode;
    public ArrayList<Node> nodes = new ArrayList<>();
    public int[][] adjMatrix;
    int size;

    public void setRootNode(Node n) {
        this.rootNode = n;
    }

    public Node getRootNode() {
        return this.rootNode;
    }

    public void addNode(Node n) {
        nodes.add(n);
    }

    public void addEdge(Node to, Node from) {
        if (adjMatrix == null) {
            size = nodes.size();
            adjMatrix = new int[size][size];
        }

        int startIndex = nodes.indexOf(from);
        int endIndex = nodes.indexOf(to);
        adjMatrix[startIndex][endIndex] = 1;
        adjMatrix[endIndex][startIndex] = 1;
    }

    public void addEdgeWeighted(Node to, Node from, int weight) {
        if (adjMatrix == null) {
            size = nodes.size();
            adjMatrix = new int[size][size];
        }

        int startIndex = nodes.indexOf(from);
        int endIndex = nodes.indexOf(to);
        adjMatrix[startIndex][endIndex] = weight;
        adjMatrix[endIndex][startIndex] = weight;
    }

    private Node getUnvisitedChildNode(Node n) {
        int index = nodes.indexOf(n);
        int j = 0;
        while (j < size) {
            if (adjMatrix[index][j] == 1 && !nodes.get(j).visited) {
                return nodes.get(j);
            }
            j++;
        }
        return null;
    }

    public GraphAdjacencyMatrix getMinimumSpanningTree() {

        final Set<Node> unvisited = new HashSet<>();
        unvisited.addAll(nodes);
        unvisited.remove(rootNode);

        final List<Edge> path = new ArrayList<>();
        final Queue<Edge> edgesAvailable = new PriorityQueue<>();

        addEdgesToNodes();

        Node vertex = rootNode;
        while (!unvisited.isEmpty()) {
            for (Edge e : vertex.getEdges()) {
                if (unvisited.contains(e.getTo()))
                    edgesAvailable.add(e);
            }

            Edge e = edgesAvailable.remove();
            while (!unvisited.contains(e.getTo()))
                e = edgesAvailable.remove();
            path.add(e);

            vertex = e.getTo();
            unvisited.remove(vertex);
        }

        return buildGraphFromPath(path);
    }

    private GraphAdjacencyMatrix buildGraphFromPath(List<Edge> path) {
        GraphAdjacencyMatrix g = new GraphAdjacencyMatrix();
        g.addNode(path.get(0).getFrom());
        for (Edge e : path) {
            g.addNode(e.getTo());
        }
        g.nodes.sort((o1, o2) -> o1.label > o2.label ? 1 : o1.label < o2.label ? -1 : 0);

        for (Edge e : path) {
            g.addEdgeWeighted(e.getTo(), e.getFrom(), e.getWeight());
        }
        return g;
    }

    private void addEdgesToNodes() {
        for (int i = 0; i < nodes.size(); i++) {
            for (int j = i; j < adjMatrix[i].length; j++) {
                if (adjMatrix[i][j] != 0)
                    nodes.get(i).getEdges().add(new Edge(nodes.get(i), nodes.get(j), adjMatrix[i][j]));
            }
        }
    }

    public void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(this.rootNode);
        printNode(this.rootNode);
        rootNode.visited = true;
        while (!q.isEmpty()) {
            Node n = q.remove();
            Node child;
            while ((child = getUnvisitedChildNode(n)) != null) {
                child.visited = true;
                printNode(child);
                q.add(child);
            }
        }
        clearNodes();
    }

    public void dfs() {
        Stack<Node> s = new Stack<>();
        s.push(this.rootNode);
        rootNode.visited = true;
        printNode(rootNode);
        while (!s.isEmpty()) {
            Node n = s.peek();
            Node child = getUnvisitedChildNode(n);
            if (child != null) {
                child.visited = true;
                printNode(child);
                s.push(child);
            } else {
                s.pop();
            }
        }
        clearNodes();
    }

    private void clearNodes() {
        int i = 0;
        while (i < size) {
            Node n = nodes.get(i);
            n.visited = false;
            i++;
        }
    }

    private void printNode(Node n) {
        System.out.print(n.label + " ");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] i : adjMatrix) {
            sb.append(Arrays.toString(i)).append("\n");
        }
        return sb.toString();
    }
}

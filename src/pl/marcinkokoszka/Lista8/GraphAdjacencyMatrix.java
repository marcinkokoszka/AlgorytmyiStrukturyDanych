package pl.marcinkokoszka.Lista8;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class GraphAdjacencyMatrix {
    private static final String NEWLINE = System.getProperty("line.separator");
    private int V;
    private int E;
    private boolean[][] adj;
    
    // empty graph with V vertices
    public GraphAdjacencyMatrix(int V) {
        if (V < 0) throw new RuntimeException("Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        this.adj = new boolean[V][V];
    }

    // random graph with V vertices and E edges
    public GraphAdjacencyMatrix(int V, int E) {
        this(V);
        if (E < 0) throw new RuntimeException("Number of edges must be nonnegative");
        if (E > V*(V-1) + V) throw new RuntimeException("Too many edges");

        Random random = new Random();
        while (this.E != E) {
            int v = random.nextInt(V);
            int w = random.nextInt(V);
            addEdge(v, w);
        }
    }

    // number of vertices and edges
    public int V() { return V; }
    public int E() { return E; }


    // add undirected edge v-w
    public void addEdge(int v, int w) {
        if (!adj[v][w]) E++;
        adj[v][w] = true;
        adj[w][v] = true;
    }
    
    // does the graph contain the edge v-w?
    public boolean contains(int v, int w) {
        return adj[v][w];
    }

    // return list of neighbors of v
    public Iterable<Integer> adj(int v) {
        return new AdjIterator(v);
    }

    // support iteration over graph vertices
    private class AdjIterator implements Iterator<Integer>, Iterable<Integer> {
        private int v;
        private int w = 0;

        AdjIterator(int v) {
            this.v = v;
        }

        public Iterator<Integer> iterator() {
            return this;
        }

        public boolean hasNext() {
            while (w < V) {
                if (adj[v][w]) return true;
                w++;
            }
            return false;
        }

        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return w++;
        }

        public void remove()  {
            throw new UnsupportedOperationException();
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            int x = 0;
            for (int w : adj(v)) {
                s.append(w + " ");
                x++;
            }
            for (int i = x; i < V; i++)
            	s.append("0 ");
            s.append(NEWLINE);
        }
        return s.toString();
    }
    
}
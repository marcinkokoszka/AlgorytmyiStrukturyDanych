package pl.marcinkokoszka.Lista8;

/**
 * Created by kokoseq on 13.06.2017.
 */

import java.util.Arrays;

//Zadanie 2 - macierz sąsiedztwa - skierowany
public class GraphAdjacencyMatrixDirected {
    private int V;
    private int E;
    private boolean[][] adjMatrix;

    public GraphAdjacencyMatrixDirected(int V) {
        this.V = V;
        this.E = 0;
        this.adjMatrix = new boolean[V][V];
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int to, int from) {
        if (!adjMatrix[from][to]) E++;
        adjMatrix[from][to] = true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (boolean[] i : adjMatrix) {
            sb.append(Arrays.toString(i) + "\n");
        }
        return sb.toString().replaceAll("true", "1").replaceAll("false", "0");
    }
}
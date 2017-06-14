package pl.marcinkokoszka.Lista8;

/**
 * Created by kokoseq on 13.06.2017.
 */

import java.util.Arrays;

//Zadanie 2 - macierz sąsiedztwa - skierowany
public class GraphIncidenceMatrixDirected {
    private int V;
    private int E;
    private int[][] incMatrix;

    public GraphIncidenceMatrixDirected(int V) {
        this.V = V;
        this.E = 0;
        this.incMatrix = new int[V][V];
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int to, int from) {
        if (incMatrix[from][to] != 0) E++;
        incMatrix[from][to] = 1;
        incMatrix[to][from] = -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] i : incMatrix) {
            sb.append(Arrays.toString(i) + "\n");
        }
        return sb.toString();
    }
}
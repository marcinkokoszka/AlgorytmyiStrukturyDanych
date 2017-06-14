package pl.marcinkokoszka.Lista8;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by kokoseq on 13.06.2017.
 */
//Zadanie 2 - Lista sąsiedztwa - skierowany
public class GraphAdjacencyListDirected {

    private Map<Integer, List<Integer>> adjacencyList;

    public GraphAdjacencyListDirected(int v) {
        adjacencyList = new java.util.HashMap<>();

        for (int i = 1; i <= v; i++)
            adjacencyList.put(i, new LinkedList<>());
    }

    public void addEdge(int to, int from) {
        if (to > adjacencyList.size() || from > adjacencyList.size())
            System.out.println("Wierzchołek nie istnieje");

        List<Integer> dls = adjacencyList.get(from);
        dls.add(to);
    }

    public List<Integer> getEdge(int from) {
        if (from > adjacencyList.size()) {
            System.out.println("Krawędź nie istnieje");
            return null;
        }

        return adjacencyList.get(from);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= adjacencyList.size(); i++) {
            sb.append(i).append(" -> ");
            List<Integer> edgeList = this.getEdge(i);
            if (edgeList.size() == 0)
                sb.append("Brak sąsiadów");
            else
                for (int j = 1; ; j++) {
                    if (j != edgeList.size())
                        sb.append(edgeList.get(j - 1)).append(" -> ");
                    else {
                        sb.append(edgeList.get(j - 1));
                        break;
                    }
                }
            sb.append("\n");
        }
        return sb.toString();
    }
}

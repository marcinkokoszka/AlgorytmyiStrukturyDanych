package pl.marcinkokoszka.Lista8;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//Zadanie 2 - Lista sąsiedztwa - nieskierowany
public class GraphAdjacencyList {
    private Map<Integer, List<Integer>> adjacencyList;

    public GraphAdjacencyList(int v) {
        adjacencyList = new HashMap<>();

        for (int i = 1; i <= v; i++)
            adjacencyList.put(i, new LinkedList<>());
    }

    public void addEdge(int to, int from) {
        if (to > adjacencyList.size() || from > adjacencyList.size())
            System.out.println("Wierzchołek nie istnieje");

        List<Integer> sls = adjacencyList.get(to);
        sls.add(from);

        List<Integer> dls = adjacencyList.get(from);
        dls.add(to);
    }

    public List<Integer> getEdge(int to) {
        if (to > adjacencyList.size()) {
            System.out.println("Krawędź nie istnieje");
            return null;
        }

        return adjacencyList.get(to);
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
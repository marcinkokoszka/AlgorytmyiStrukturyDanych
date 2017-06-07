package pl.marcinkokoszka.Lista8;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GraphAdjacencyList {
    private Map<Integer, List<Integer>> adjacencyList;

    public GraphAdjacencyList(int v) {
        adjacencyList = new HashMap<Integer, List<Integer>>();

        for (int i = 1; i <= v; i++)
            adjacencyList.put(i, new LinkedList<Integer>());
    }

    public void setEdge(int to, int from) {
        if (to > adjacencyList.size() || from > adjacencyList.size())
            System.out.println("Wierzcho�ek nie istnieje");

        List<Integer> sls = adjacencyList.get(to);
        sls.add(from);
        
        List<Integer> dls = adjacencyList.get(from);
        dls.add(to);
    }

    public List<Integer> getEdge(int to) {
        if (to > adjacencyList.size()) {
            System.out.println("Wierzcho�ek nie istnieje");
            return null;
        }

        return adjacencyList.get(to);
    }
    
    public void printAdjacencyList(){
        for (int i = 1; i <= adjacencyList.size(); i++) {
        	System.out.println();
            System.out.print(i + " -> ");
            List<Integer> edgeList = this.getEdge(i);
            if(edgeList.size() == 0) 
            	System.out.print("brak s�siad�w");
            else
	            for (int j = 1;; j++) {
	                if (j != edgeList.size())
	                    System.out.print(edgeList.get(j - 1) + " -> ");
	                else {
	                    System.out.print(edgeList.get(j - 1));
	                    break;
	                }
	            }
        }
    }
}
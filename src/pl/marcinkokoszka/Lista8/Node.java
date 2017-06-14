package pl.marcinkokoszka.Lista8;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public char label;
    public boolean visited = false;
    private List<Edge> edges;

    public Node(char l) {
        this.label = l;
        edges = new ArrayList<>();
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    @Override
    public String toString() {
        return String.valueOf(label);
    }
}

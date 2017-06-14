package pl.marcinkokoszka.Lista8;

/**
 * Created by kokoseq on 14.06.2017.
 */
public class Edge implements Comparable {
    private Node from;
    private Node to;
    private int weight;

    public Edge(Node from, Node to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public Node getFrom() {
        return from;
    }

    public void setFrom(Node from) {
        this.from = from;
    }

    public Node getTo() {
        return to;
    }

    public void setTo(Node to) {
        this.to = to;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Object o) {
        Edge e = (Edge) o;
        return this.weight > e.weight ? 1 : this.weight < e.weight ? -1 : 0;
    }

    @Override
    public String toString() {
        return "od " + from + " do " + to + " - " + weight;
    }
}

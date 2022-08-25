/***********************************************************************************
 * This class`s Only Purpose is for Testing, the prioritisation of edges Cost, in  *
 * an adjacency Matrix , for further implementations in weighted class                                                             *
 ***********************************************************************************/
package AdjacencyMatrix;

import java.util.Comparator;
import java.util.Objects;

public class Edge extends EdgeComparator {

    private int from;
    private int to;
    private double cost;

    private final Comparator<Edge> eedgeComparator = new EdgeComparator();

    public Comparator<Edge> getEedgeComparator() {
        return eedgeComparator;
    }

    public Edge() {
    }

    public Edge(int from, int to, double cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;

    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, cost);
    }


    @Override
    public String toString() {
        return "Edge{" +
                "node=" + from +
                ", edge=" + to +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge1 = (Edge) o;
        return from == edge1.from && to == edge1.to && Double.compare(edge1.cost, cost) == 0;
    }

    /**
     * to check the values of the priority queues, by comparing them with the expected value array
     *
     * @param a first edge array
     * @param b second edge array
     * @return true if both arrays are ordered according to the pre chosen heap invariant
     */
    public boolean areAllArrtibutesOrderd(Edge[] a, Edge... b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i].from != b[i].from ||
                    a[i].cost != b[i].cost ||
                    a[i].to != b[i].to) {
                return false;
            }
        }
        return true;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public double getCost() {
        return cost;
    }
}


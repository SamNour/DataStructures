/***********************************************************************************
 * This class`s Only Purpose is for Testing, the prioritisation of edges Cost, in  *
 * an adjacency Matrix                                                             *
 ***********************************************************************************/
package AdjacencyMatrix;

import java.util.Objects;

public class Edge implements Comparable<Edge> {
    private int node;
    private int edge;
    private double cost;

    public Edge() {
    }

    public Edge(int node, int edge, double cost) {
        this.node = node;
        this.edge = edge;
        this.cost = cost;
    }

    @Override
    public int hashCode() {
        return Objects.hash(node, edge, cost);
    }

    @Override
    public int compareTo(Edge o) {
        if (this.cost > o.cost) {
            return 1;
        } else if (this.cost < o.cost) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "node=" + node +
                ", edge=" + edge +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge1 = (Edge) o;
        return node == edge1.node && edge == edge1.edge && Double.compare(edge1.cost, cost) == 0;
    }

    public boolean areAllArrtibutesOrderd(Edge[] a, Edge... b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i].node != b[i].node ||
                    a[i].cost != b[i].cost ||
                    a[i].edge != b[i].edge) {
                return false;
            }
        }
        return true;
    }
}

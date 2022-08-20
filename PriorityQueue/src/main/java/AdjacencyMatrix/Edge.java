/***********************************************************************************
 * This class`s Only Purpose is for Testing, the prioritisation of edges Cost, in  *
 * an adjacency Matrix , for further implementations in weighted class                                                             *
 ***********************************************************************************/
package AdjacencyMatrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class Edge extends EdgeComparator {

    private int node;
    private int edge;
    private double cost;

    private Comparator<Edge> eedgeComparator = new EdgeComparator();

    public Comparator<Edge> getEedgeComparator() {
        return eedgeComparator;
    }

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
            if (a[i].node != b[i].node ||
                    a[i].cost != b[i].cost ||
                    a[i].edge != b[i].edge) {
                return false;
            }
        }
        return true;
    }

    public int getNode() {
        return node;
    }

    public int getEdge() {
        return edge;
    }

    public double getCost() {
        return cost;
    }
}
class EdgeComparator implements Comparator<Edge> {


    @Override
    public int compare(Edge edge, Edge t1) {
        return Comparator.comparing(Edge::getNode).
                thenComparing(Edge::getCost).
                compare(edge,t1);
    }

    public static void main(String[] args) {
       Edge[] edgeArrayCostDec = new Edge[]{
                new Edge(1, 1, 3),
                new Edge(0, 1, 1),
                new Edge(0, 1, 0),
                new Edge(0, 1, -1),
                new Edge(1, 2, -12),
        };
        Comparator<Edge> edgeComparator = new EdgeComparator();
        ArrayList<Edge> arrayList = new ArrayList<>(java.util.List.of(edgeArrayCostDec));
        Collections.sort(arrayList,edgeComparator);
        System.out.println(arrayList);
    }
}

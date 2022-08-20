package AdjacencyMatrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EdgeComparator implements Comparator<Edge> {


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
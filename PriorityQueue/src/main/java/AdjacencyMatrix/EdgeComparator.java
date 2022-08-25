package AdjacencyMatrix;

import java.util.Comparator;

public class EdgeComparator implements Comparator<Edge> {

    @Override
    public int compare(Edge edge, Edge t1) {
        return Comparator.comparing(Edge::getFrom).
                thenComparing(Edge::getCost).
                compare(edge, t1);
    }


}
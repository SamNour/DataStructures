package AdjacencyMatrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EdgeComparator implements Comparator<Edge> {


    @Override
    public int compare(Edge edge, Edge t1) {
        return Comparator.comparing(Edge::getNode).
                thenComparing(Edge::getCost).
                compare(edge, t1);
    }


}
import AdjacencyMatrix.Edge;
import PriorityQueuePackage.Abstraction;
import PriorityQueuePackage.MaxHeap;
import PriorityQueuePackage.MinHeap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class priorityQueueTest {

    private Edge edge;

    private Edge[] testEdgeArray;

    private Edge[] edgeArrayCostDec;

    private Edge[] edgeArrayCostInc;

    private Abstraction<Edge> edgeMinHeap;

    private Abstraction<Edge> edgeMaxHeap;

    private Abstraction<Integer> maxHeap;

    private Abstraction<Integer> minHeap;

    private Integer[] integers;

    @BeforeEach
    void setup() {
        edge = new Edge();

        testEdgeArray = new Edge[]{
                new Edge(0, 1, 0),
                new Edge(0, 1, 1),
                new Edge(0, 1, -1),
                new Edge(1, 2, 3),
                new Edge(1, 2, -12)
        };
        edgeArrayCostInc = new Edge[]{
                new Edge(1, 2, -12),
                new Edge(0, 1, -1),
                new Edge(0, 1, 0),
                new Edge(0, 1, 1),
                new Edge(1, 2, 3),
        };

        edgeArrayCostDec = new Edge[]{
                new Edge(1, 2, 3),
                new Edge(0, 1, 1),
                new Edge(0, 1, 0),
                new Edge(0, 1, -1),
                new Edge(1, 2, -12),
        };

        integers = new Integer[]{1, 2, 3, 4, 5, 6};
    }


    @Test
    void areEdgesCostsOrderdAscendingly() {
        edgeMinHeap = new Abstraction<>(new MinHeap<>(testEdgeArray));

        Edge[] expected = edgeArrayCostInc;
        Edge[] result = new Edge[edgeMinHeap.getSize()];

        for (int i = 0; i < result.length; i++) {
            result[i] = edgeMinHeap.pop();
        }

        assertTrue(edge.areAllArrtibutesOrderd(expected, result));
    }

    @Test
    void areEdgesCostsOrderdDescendingly() {
        edgeMaxHeap = new Abstraction<>(new MaxHeap<>(testEdgeArray));

        Edge[] expected = edgeArrayCostDec;
        Edge[] result = new Edge[edgeMaxHeap.getSize()];

        for (int i = 0; i < result.length; i++) {
            result[i] = edgeMaxHeap.pop();
        }

        assertTrue(edge.areAllArrtibutesOrderd(expected, result));
    }

    @Test
    void minHeapDecreaseKeyTest() {
        minHeap = new Abstraction<>(new MinHeap<>(integers));

        boolean areArraysShallowEqual = true;

        Integer[] expected = new Integer[]{0, 2, 3, 4, 5, 6};
        Integer[] results = new Integer[expected.length];

        minHeap.decreaseKey(1, 0);

        for (int i = 0; i < expected.length; i++) {
            results[i] = minHeap.pop();
        }

//        System.out.println(Arrays.toString(results));
//        System.out.println(Arrays.toString(expected));
        /*
        checking equality of each of the arrays` inputs
         */
        for (int i = 0; i < expected.length; i++) {
            if ((expected[i].compareTo(results[i])) == 0) {
                continue;
            } else {
                areArraysShallowEqual = false;
                break;
            }

        }
        assertTrue(areArraysShallowEqual);
    }

    @Test
    void maxHeapincreaseKeyTest() {
        maxHeap = new Abstraction<>(new MaxHeap<>(integers));

        boolean areArraysShallowEqual = true;

        Integer[] expected = new Integer[]{12, 5, 4, 3, 2, 1};
        Integer[] results = new Integer[expected.length];

        maxHeap.increaseKey(6, 12);

        for (int i = 0; i < expected.length; i++) {
            results[i] = maxHeap.pop();
        }

//        System.out.println(Arrays.toString(results));
//        System.out.println(Arrays.toString(expected));

        for (int i = 0; i < expected.length; i++) {
            if ((expected[i].compareTo(results[i])) == 0) {
                continue;
            } else {
                areArraysShallowEqual = false;
                break;
            }
        }

        assertTrue(areArraysShallowEqual);
    }

    @Test
    void minHeapDecreaseThrowsException() {
        minHeap = new Abstraction<>(new MinHeap<>(integers));
        minHeap.decreaseKey(1, 0);
        assertThrows(IllegalArgumentException.class, () -> minHeap.decreaseKey(1, 24));
    }

    @Test
    void minHeapIncreaseThrowsException() {
        minHeap = new Abstraction<>(new MinHeap<>(integers));
        minHeap.decreaseKey(1, 0);
        assertThrows(IllegalArgumentException.class, () -> minHeap.increaseKey(1, -11));
    }

    @Test
    void testFindThrows() {
        minHeap = new Abstraction<>(new MinHeap<>(integers));
        MinHeap<Integer> emptyHeap = new MinHeap<>();
        //testing if element does not exist
        assertThrows(IllegalArgumentException.class, () -> minHeap.find(100));
        //Heap is empty
        assertThrows(IllegalArgumentException.class, () -> emptyHeap.find(100));
    }

    @Test
    void testingAgainJavaUtilPriorityQueueMinHeap() {
        boolean areArraysShallowEqual = true;

        Integer[] integers = new Integer[]{1, 2, 3, 0, 4, 5, 12, 21, -10, 123, 214, 123, -12};
        Abstraction<Integer> abstraction = new Abstraction<Integer>(new MinHeap<>(integers));
        //contains my minHeap
        Integer[] results = new Integer[abstraction.getSize()];
        //contains java.util minHeap
        Integer[] expected = new Integer[abstraction.getSize()];
        //adding My minHeap into array result
        for (int i = 0; i < integers.length; i++) {
            results[i] = abstraction.pop();
        }
        //adding java.util heap into expected
        java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<Integer>(List.of(integers));
        for (int i = 0; i < expected.length; i++) {
            expected[i] = pq.poll();
        }
        //comparing shallow equality with respect to the order of elements
        for (int i = 0; i < expected.length; i++) {
            if ((expected[i].compareTo(results[i])) == 0) {
                continue;
            } else {
                areArraysShallowEqual = false;
                break;
            }
        }

        assertTrue(areArraysShallowEqual);
    }


    @Test
    void testingAgainJavaUtilPriorityQueueMaxHeap() {
        boolean areArraysShallowEqual = true;

        Integer[] integers = new Integer[]{1, 2, 3, 0, 4, 5, 12, 21, -10, 123, 214, 123, -12};
        Abstraction<Integer> abstraction = new Abstraction<Integer>(new MaxHeap<>(integers));
        //contains my minHeap
        Integer[] results = new Integer[abstraction.getSize()];
        //contains java.util minHeap
        Integer[] expected = new Integer[abstraction.getSize()];
        //adding My minHeap into array result
        for (int i = 0; i < integers.length; i++) {
            results[i] = abstraction.pop();
        }
        //adding java.util heap into expected
        java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<Integer>(Collections.reverseOrder());
        pq.addAll(List.of(integers) );
        for (int i = 0; i < expected.length; i++) {
            expected[i] = pq.poll();
        }
        //comparing shallow equality with respect to the order of elements
        for (int i = 0; i < expected.length; i++) {
            if ((expected[i].compareTo(results[i])) == 0) {
                continue;
            } else {
                areArraysShallowEqual = false;
                break;
            }
        }

        assertTrue(areArraysShallowEqual);
    }
}

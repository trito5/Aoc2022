package utils;

import java.util.ArrayList;
import java.util.List;

public class Tests {
    public static void run() {
        Node n1 = new Node(2, 1);
        Node n2 = new Node(3, 4);
        Node n3 = new Node(-4, 1);
        Node n4 = new Node(1, -3);
        Node n5 = new Node(1, -3);
        List<Node> nodes = new ArrayList<>();
        nodes.add(n1);
        nodes.add(n2);
        nodes.add(n3);
        nodes.add(n4);
        nodes.add(n5);
        System.out.println();
        System.out.println(" ---- TEST CLASSES ----");
        System.out.println("Manhattan distance should be 4: " + n1.getManhattanDistance(n2));
        assert n1.getManhattanDistance(n2) == 4;
        System.out.println("Manhattan distance should be 9: " + n3.getManhattanDistance(n4));
        assert n1.getManhattanDistance(n4) == 9;
        System.out.println("Hypothenus should be about 3.16227766: " + n1.getHypothenus(n2));
        System.out.println("Hypothenus should be about 6.403124237: " + n3.getHypothenus(n4));
        System.out.println("Nodes are equals? Should be true: " + n4.equals(n5));
        System.out.println("Nodes are equals? Should be false: " + n4.equals(n3));
        System.out.println("Min distance: " + Common.getShortestDistance(new Node(0,0), nodes));
        System.out.println("Max distance: " + Common.getLongestDistance(new Node(0,0), nodes));
        System.out.println("Sum distance: " + Common.getMaxDistance(nodes));
        System.out.println("Count unique nodes: " + Common.countUniqueNodes(nodes));
        System.out.println("Count nodes: " + Common.createNodesCount(nodes));
    }

}

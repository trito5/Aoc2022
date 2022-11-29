package utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Common {
    public static int getShortestDistance(Node node, List<Node> nodes) {
        return nodes.stream()
                .mapToInt(n -> n.getManhattanDistance(node))
                .min()
                .getAsInt();
    }

    public static int getLongestDistance(Node node, List<Node> nodes) {
        return nodes.stream()
                .mapToInt(n -> n.getManhattanDistance(node))
                .max()
                .getAsInt();
    }

    public static int getMaxDistance(List<Node> nodes) {
        return nodes.stream()
                .mapToInt(n -> n.getManhattanDistance(new Node(0, 0)))
                .sum();
    }

    public static int countUniqueNodes(List<Node> nodes) {
        Set<Node> nodeSet = new HashSet<>(nodes);
        return nodeSet.size();
    }

    public static Map<Node, Integer> createNodesCount(List<Node> nodes) {
        Map<Node, Integer> map = new HashMap<>();
        for (Node n : nodes) {
            int value = map.getOrDefault(n, 0) + 1;
            map.put(n, value);
        }
        return map;
    }
}

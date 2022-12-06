package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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

    public static Node getMostOccurrenceNode(Map<Node, Integer> map) {
        return map.entrySet().stream().max(Entry.comparingByValue()).get().getKey();
    }

    public static int getMostOccurrenceValue(Map<Node, Integer> map) {
        return map.entrySet().stream().max(Entry.comparingByValue()).orElseThrow().getValue();
    }

    public static List<Node> createNodes(List<String> input) {
        List<Node> nodes = new ArrayList<>();
        for (int y = 0; y < input.size(); y++) {
            for (int x = 0; x < input.get(y).length(); x++) {
                Node n = new Node(x, y, input.get(y).charAt(x));
                nodes.add(n);
            }
        }
        return nodes;
    }

    public static void drawNodes(List<Node> nodes) {
        int row = 0;
        for (Node n : nodes) {
            if (n.y != row) {
                System.out.println();
                row = n.y;
            }
            System.out.printf(String.valueOf(n.c));
        }
    }
}

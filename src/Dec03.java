import java.util.List;
import static utils.FileReader.toStringList;

public class Dec03 {

    public static void run() {
        List<String> input = toStringList("files/3.txt");
        part1(input);
        part2(input);
    }

    public static void part1(List<String> input) {
        int score = 0;
        for (String s : input) {
            int half = s.length() / 2;
            String first = s.substring(0, half);
            String second = s.substring(half);
            for (char c : first.toCharArray()) {
                if (second.contains(String.valueOf(c))) {
                    score += getPrio(c);
                    break;
                }
            }
        }
        System.out.println("part 1: " + score);
    }

    public static void part2(List<String> input) {
        int score = 0;
        for (int i = 0; i < input.size() - 2; i = i + 3) {
            String first = input.get(i);
            String second = input.get(i + 1);
            String third = input.get(i + 2);
            for (char c : first.toCharArray()) {
                if (second.contains(String.valueOf(c)) && third.contains(String.valueOf(c))) {
                    score += getPrio(c);
                    break;
                }
            }
        }
        System.out.println("part 2: " + score);
    }

    private static int getPrio(char c) {
        String s = String.valueOf(c);
        if (s.toLowerCase().equals(s)) {
            return c - 96;
        }
        return c - 38;
    }
}

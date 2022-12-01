import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static utils.FileReader.toStringList;

public class Dec01 {

    public static void run() {
        List<String> input = toStringList("files/1.txt");
        part1(input);
        part2(input);
    }

    public static void part1(List<String> input) {
        final List<Integer> cals = countCalories(input);
        System.out.println("part 1: " + cals.get(0));
    }

    public static void part2(List<String> input) {
        final List<Integer> cals = countCalories(input);
        int total = cals.get(0) + cals.get(1) + cals.get(2);
        System.out.println("part 2: " + total);

    }

    private static List<Integer> countCalories(List<String> input) {
        List<Integer> cals = new ArrayList<>();
        int cal = 0;
        for (String s : input) {
            if (s.isEmpty()) {
                cals.add(cal);
                cal = 0;
            } else {
                cal += Integer.parseInt(s.trim());
            }
        }
        cals.sort(Collections.reverseOrder());
        return cals;
    }
}

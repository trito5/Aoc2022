import java.util.HashSet;
import java.util.Set;
import static utils.FileReader.readToString;

public class Dec06 {

    public static void run() {
        String input = readToString("files/6.txt");
        part1(input);
        part2(input);
    }

    public static void part1(String s) {
        int sum = 3;
        for (int i = 0; i < s.length() - 3; i++) {
            sum++;
            if (checkwindow(s, i, 4))
                break;
        }
        System.out.println("part 1: " + sum);
    }

    public static void part2(String s) {
        int sum = 13;
        for (int i = 0; i < s.length() - 13; i++) {
            sum++;
            if (checkwindow(s, i, 14))
                break;
        }
        System.out.println("part 2: " + sum);
    }

    private static boolean checkwindow(String s, int start, int unique) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < start + unique; i++) {
            set.add(s.charAt(i));
        }
        return set.size() == unique;
    }
}

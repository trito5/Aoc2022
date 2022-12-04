import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static utils.FileReader.toStringList;

public class Dec04 {

    public static void run() {
        List<String> input = toStringList("files/4.txt");
        part1(input);
        part2(input);
    }

    public static void part1(List<String> input) {
        int counter = 0;
        for (String s : input) {
            int[] elf1 = convertTasks(s.split(",")[0]);
            int[] elf2 = convertTasks(s.split(",")[1]);

            if ((elf1[0] >= elf2[0] && elf1[1] <= elf2[1]) || (elf1[1] >= elf2[1] && elf1[0] <= elf2[0])) {
                counter++;
            }
        }

        System.out.println("part 1: " + counter);
    }

    public static void part2(List<String> input) {
        int counter = 0;
        for (String s : input) {
            int[] elf1 = convertTasks(s.split(",")[0]);
            int[] elf2 = convertTasks(s.split(",")[1]);

            Set<Integer> tasks = new HashSet<>();
            int elf1Counter = 0;
            for (int i = elf1[0]; i <= elf1[1]; i++) {
                tasks.add(i);
                elf1Counter++;
            }

            int elf2Counter = 0;
            for (int i = elf2[0]; i <= elf2[1]; i++) {
                tasks.add(i);
                elf2Counter++;
            }

            if (tasks.size() != elf1Counter + elf2Counter) {
                counter++;
            }
        }

        System.out.println("part 2: " + counter);
    }

    private static int[] convertTasks(String tasks) {
        int[] elfTasks = new int[2];
        String[] startAndStop = tasks.split("-");
        elfTasks[0] = Integer.parseInt(startAndStop[0]);
        elfTasks[1] = Integer.parseInt(startAndStop[1]);
        return elfTasks;
    }

}

import java.io.IOException;
import java.util.List;

import static utils.FileReader.toIntList;
import static utils.InputFetcher.createInputFiles;

public class Test2021Dec01 {

    public static void run() throws IOException, InterruptedException {
        List<Integer> input = toIntList("files/1.txt");
        createInputFiles();
        part1(input);
        part2(input);
    }

    public static void part1(List<Integer> input) {
        int c = 0;
        for (int i = 1; i < input.size(); i++) {
            if (input.get(i) > input.get(i - 1))
                c++;
        }
        System.out.println("Part 1: " + c );
    }

    public static void part2(List<Integer> input) {
        int c = 0;
        int measure = Integer.MAX_VALUE;
        for (int i = 0; i < input.size() -2; i++) {
            int window = input.get(i) + input.get(i + 1) + input.get(i + 2);
            if (window > measure) {
                c++;
            }
            measure = window;
        }
        System.out.println("Part 2: " + c );
    }
}

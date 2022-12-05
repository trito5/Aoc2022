import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import static utils.FileReader.toStringList;

public class Dec05 {
    public static final int INSTR_START = 10;

    public static void run() {
        List<String> input = toStringList("files/5.txt");
        part1(input);
        part2(input);
    }

    public static void part1(List<String> input) {
        List<Stack<Character>> stacks = parseStacks(input);
        for (int ir = INSTR_START; ir < input.size(); ir++) {
            final String[] instr = input.get(ir).split(" from ");
            int num = getNumbers(instr);
            int start = getStart(instr);
            int end = getEnd(instr);
            for (int i = 0; i < num; i++) {
                char move = stacks.get(start - 1).pop();
                stacks.get(end - 1).add(move);
            }
        }
        System.out.println("Answer part1:");
        for (Stack<Character> stack : stacks) {
            char pop = stack.pop();
            System.out.printf(String.valueOf(pop));
        }
    }

    public static void part2(List<String> input) {
        List<Stack<Character>> stacks = parseStacks(input);

        for (int ir = INSTR_START; ir < input.size(); ir++) {
            final String[] instr = instructions(input, ir);
            int num = getNumbers(instr);
            int start = getStart(instr);
            int end = getEnd(instr);
            Stack<Character> temp = new Stack<>();
            for (int i = 0; i < num; i++) {
                char move = stacks.get(start - 1).pop();
                temp.add(move);
            }
            while (!temp.empty()) {
                char move = temp.pop();
                stacks.get(end - 1).add(move);
            }
        }
        System.out.println("\n\rpart 2: ");
        for (Stack<Character> stack : stacks) {
            char pop = stack.pop();
            System.out.printf(String.valueOf(pop));
        }
    }

    private static int getNumbers(String[] instr) {
        return Integer.parseInt(instr[0].replace("move ", ""));
    }

    private static int getEnd(final String[] instr) {
        return Integer.parseInt(String.valueOf(instr[1].charAt(5)));
    }

    private static int getStart(final String[] instr) {
        return Integer.parseInt(String.valueOf(instr[1].charAt(0)));
    }

    private static String[] instructions(final List<String> input, final int ir) {
        return input.get(ir).split(" from ");
    }

    private static List<Stack<Character>> parseStacks(List<String> input) {
        List<Stack<Character>> tempStacks = new ArrayList<>();
        List<Stack<Character>> stacks = new ArrayList<>();
        for (int i = 0; i < INSTR_START -1; i++) {
            Stack<Character> list = new Stack<>();
            Stack<Character> tempList = new Stack<>();
            stacks.add(list);
            tempStacks.add(tempList);
        }
        for (int i = 0; i < INSTR_START -1; i++) {
            String s = input.get(i).replace("    ", " - ").replace("[", "")
                           .replace("]", "").replace(" ", "");
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) != '-') {
                    tempStacks.get(j).add(s.charAt(j));
                }
            }
        }

        for (int m = 0; m < tempStacks.size(); m++) {
            while (!tempStacks.get(m).empty()) {
                var pop = tempStacks.get(m).pop();
                stacks.get(m).add(pop);
            }
        }
        return stacks;
    }
}

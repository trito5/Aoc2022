import java.util.List;
import static utils.FileReader.toStringList;

public class Dec02 {

    private final static int LOST = 0;
    private final static int DRAW = 3;
    private final static int WIN = 6;
    private final static int ROCK = 1;
    private final static int PAPER = 2;
    private final static int SCISSORS = 3;
    private final static String A = "A";
    private final static String B = "B";
    private final static String C = "C";
    private final static String X = "X";
    private final static String Y = "Y";
    private final static String Z = "Z";

    public static void run() {
        List<String> input = toStringList("files/2.txt");
        part1(input);
        part2(input);
    }

    public static void part1(List<String> input) {
        int score = 0;
        for (String s : input) {
            final String[] line = s.split(" ");
            score += calcRoundPart1(line[0].trim(), line[1].trim());
        }
        System.out.println("part 1: " + score);
    }


    private static int calcRoundPart1(String first, String second) {
        if (first.equals(A) && second.equals(X)) {
            return DRAW + ROCK;
        } else if (first.equals(A) && second.equals(Y)) {
            return WIN + PAPER;
        } else if (first.equals(A) && second.equals(Z)) {
            return LOST + SCISSORS;
        } else if (first.equals(B) && second.equals(X)) {
            return LOST + ROCK;
        } else if (first.equals(B) && second.equals(Y)) {
            return DRAW + PAPER;
        } else if (first.equals(B) && second.equals(Z)) {
            return WIN + SCISSORS;
        } else if (first.equals(C) && second.equals(X)) {
            return WIN + ROCK;
        } else if (first.equals(C) && second.equals(Y)) {
            return LOST + PAPER;
        } else if (first.equals(C) && second.equals(Z)) {
            return DRAW + SCISSORS;
        } else {
            System.out.println("Something went wrong.....");
            return - 100000000;
        }
    }

    public static void part2(List<String> input) {
        int score = 0;
        for (String s : input) {
            final String[] line = s.split(" ");
            score += calcRoundPart2(line[0].trim(), line[1].trim());
        }
        System.out.println("part 2: " + score);
    }

    private static int calcRoundPart2(String first, String second) {
        if (first.equals(A) && second.equals(X)) {
            return LOST + SCISSORS;
        } else if (first.equals(A) && second.equals(Y)) {
            return DRAW + ROCK;
        } else if (first.equals(A) && second.equals(Z)) {
            return WIN + PAPER;
        } else if (first.equals(B) && second.equals(X)) {
            return LOST + ROCK;
        } else if (first.equals(B) && second.equals(Y)) {
            return DRAW + PAPER;
        } else if (first.equals(B) && second.equals(Z)) {
            return WIN + SCISSORS;
        } else if (first.equals(C) && second.equals(X)) {
            return LOST + PAPER;
        } else if (first.equals(C) && second.equals(Y)) {
            return DRAW + SCISSORS;
        } else if (first.equals(C) && second.equals(Z)) {
            return WIN + ROCK;
        } else {
            System.out.println("Something went wrong.....");
            return - 100000000;
        }
    }
}

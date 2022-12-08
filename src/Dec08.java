import java.util.List;
import static utils.FileReader.toStringList;

public class Dec08 {

    public static void run() {
        List<String> input = toStringList("files/8.txt");
        part1(input);
        part2(input);
    }

    public static void part1(List<String> input) {
        int c = (input.size() * 2) + ((input.get(0).length() - 2)*2) ;
        for (int i = 1; i < input.size() - 1; i++) {
            for (int j = 1; j < input.get(i).length() - 1; j++) {
                int tree = Integer.parseInt(String.valueOf((input.get(i).charAt(j))));
                if (checkUp(i, j, tree, input) == 1) {
                    c++;
                    continue;
                }
                if (checkDown(i, j, tree, input) == 1) {
                    c++;
                    continue;
                }
                if (checkLeft(i, j, tree, input) == 1) {
                    c++;
                    continue;
                }
                if (checkRight(i, j, tree, input) == 1) {
                    c++;
                }
            }
        }
        System.out.println("part 1: " + c);
    }

    public static void part2(List<String> input) {
        int max = 0;
        for (int i = 1; i < input.size() - 1; i++) {
            for (int j = 1; j < input.get(i).length() - 1; j++) {
                int tree = Integer.parseInt(String.valueOf((input.get(i).charAt(j))));

                int rightCounter = checkRightDistance(i, j, tree, input);
                int leftCounter = checkLeftDistance(i, j, tree, input);
                int upCounter = checkUpDistance(i, j, tree, input);
                int downCounter = checkDownDistance(i, j, tree, input);
                int sum = rightCounter * leftCounter * upCounter * downCounter;
                max = Math.max(sum, max);
            }
        }
        System.out.println("part 2: " + max);
    }

    private static int checkRight(int y, int x, int tree, List<String> input) {
        for (int k = x + 1; k < input.get(y).length(); k++) {
            if (checkNeighbour(y, k, tree, input)) {
                return 0;
            }
        }
        return 1;
    }

    private static int checkRightDistance(int y, int x, int tree, List<String> input) {
        int c = 0;
        for (int k = x + 1; k < input.get(y).length(); k++) {
            c++;
            if (checkNeighbour(y, k, tree, input)) {
                break;
            }
        }
        return c;
    }

    private static int checkLeft(int y, int x, int tree, List<String> input) {
        for (int k = x - 1; k >= 0; k--) {
            if (checkNeighbour(y, k, tree, input)) {
                return 0;
            }
        }
        return 1;
    }

    private static int checkLeftDistance(int y, int x, int tree, List<String> input) {
        int c = 0;
        for (int k = x - 1; k >= 0; k--) {
            c++;
            if (checkNeighbour(y, k, tree, input)) {
                break;
            }
        }
        return c;
    }

    private static int checkUp(int y, int x, int tree, List<String> input) {
        for (int k = y - 1; k >= 0; k--) {
            if (checkNeighbour(k, x, tree, input)) {
                return 0;
            }
        }
        return 1;
    }

    private static int checkUpDistance(int y, int x, int tree, List<String> input) {
        int c = 0;
        for (int k = y - 1; k >= 0; k--) {
            c++;
            if (checkNeighbour(k, x, tree, input)) {
                break;
            }
        }
        return c;
    }

    private static int checkDown(int y, int x, int tree, List<String> input) {
        for (int k = y + 1; k < input.size(); k++) {
            if (checkNeighbour(k, x, tree, input)) {
                return 0;
            }
        }
        return 1;
    }

    private static int checkDownDistance(int y, int x, int tree, List<String> input) {
        int c = 0;
        for (int k = y + 1; k < input.size(); k++) {
            c++;
            if (checkNeighbour(k, x, tree, input)) {
                break;
            }
        }
        return c;
    }

    private static boolean checkNeighbour(int y, int x, int tree, List<String> input) {
        int neighbour = Integer.parseInt(String.valueOf((input.get(y).charAt(x))));
        return neighbour >= tree;
    }

}

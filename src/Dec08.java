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
                if (isUpFree(i, j, tree, input)) {
                    c++;
                    continue;
                }
                if (isDownFree(i, j, tree, input)) {
                    c++;
                    continue;
                }
                if (isLeftFree(i, j, tree, input)) {
                    c++;
                    continue;
                }
                if (isRightFree(i, j, tree, input)) {
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

                int rightCounter = calcRight(i, j, tree, input);
                int leftCounter = calcLeft(i, j, tree, input);
                int upCounter = calcUp(i, j, tree, input);
                int downCounter = calcDown(i, j, tree, input);
                int sum = rightCounter * leftCounter * upCounter * downCounter;
                max = Math.max(sum, max);
            }
        }
        System.out.println("part 2: " + max);
    }

    private static boolean isRightFree(int y, int x, int tree, List<String> input) {
        for (int k = x + 1; k < input.get(y).length(); k++) {
            if (checkNeighbour(y, k, tree, input)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isLeftFree(int y, int x, int tree, List<String> input) {
        for (int k = x - 1; k >= 0; k--) {
            if (checkNeighbour(y, k, tree, input)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isUpFree(int y, int x, int tree, List<String> input) {
        for (int k = y - 1; k >= 0; k--) {
            if (checkNeighbour(k, x, tree, input)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isDownFree(int y, int x, int tree, List<String> input) {
        for (int k = y + 1; k < input.size(); k++) {
            if (checkNeighbour(k, x, tree, input)) {
                return false;
            }
        }
        return true;
    }

    private static int calcRight(int y, int x, int tree, List<String> input) {
        int c = 0;
        for (int k = x + 1; k < input.get(y).length(); k++) {
            c++;
            if (checkNeighbour(y, k, tree, input)) {
                break;
            }
        }
        return c;
    }

    private static int calcLeft(int y, int x, int tree, List<String> input) {
        int c = 0;
        for (int k = x - 1; k >= 0; k--) {
            c++;
            if (checkNeighbour(y, k, tree, input)) {
                break;
            }
        }
        return c;
    }

    private static int calcUp(int y, int x, int tree, List<String> input) {
        int c = 0;
        for (int k = y - 1; k >= 0; k--) {
            c++;
            if (checkNeighbour(k, x, tree, input)) {
                break;
            }
        }
        return c;
    }

    private static int calcDown(int y, int x, int tree, List<String> input) {
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

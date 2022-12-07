import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import static utils.FileReader.toStringList;

public class Dec07 {

    public static void run() {
        List<String> input = toStringList("files/7.txt");
        part1(input);
        part2(input);
    }

    public static void part1(List<String> input) {
        Dir start = new Dir();
        createDirs(input, start, 1);
        List<Dir> dirs = new ArrayList<>();
        initAllFolderSizes(start, dirs);

        int size = dirs.stream()
                       .map(d -> d.folderSize)
                       .filter(s -> s < 100000)
                       .reduce(0, Integer::sum);

        System.out.println("part 1: " + size);
    }

    public static void part2(List<String> input) {
        Dir start = new Dir();
        createDirs(input, start, 1);
        List<Dir> dirs = new ArrayList<>();
        initAllFolderSizes(start, dirs);
        int usedSize = start.folderSize;
        int freeSpace = 70000000 - usedSize;
        int neededSpace = 30000000 - freeSpace;
        int size = dirs.stream()
                       .filter(d -> d.folderSize > neededSpace)
                       .sorted()
                       .findFirst()
                       .map(d -> d.folderSize)
                       .orElseThrow();

        System.out.println("Part 2: " + size);
    }

    private static class Dir implements Comparable<Dir> {
        private int folderSize = 0;
        private final Map<String, Integer> files = new HashMap<>();
        private final Map<String, Dir> paths = new HashMap<>();

        @Override
        public int compareTo(Dir other) {
            return Integer.compare(folderSize, other.folderSize);
        }
    }

    private static int createDirs(List<String> input, Dir dir, int i) {
        i++;
        for (; i < input.size(); i++) {
            String line = input.get(i);
            if (line.startsWith("dir ")) {
                String dirId = line.substring(4);
                dir.paths.put(dirId, new Dir());
            } else if (line.startsWith("$ cd ..")) {
                return i;
            } else if (line.startsWith("$ cd ")) {
                String dirId = line.substring(5);
                i = createDirs(input, dir.paths.get(dirId), i + 1);
            } else {
                int fileSize = Integer.parseInt(line.split(" ")[0]);
                String fileName = line.split(" ")[1];
                dir.files.put(fileName, fileSize);
            }
        }
        return i;
    }

    private static void initAllFolderSizes(Dir dir, List<Dir> dirs) {
        for (Dir d : dir.paths.values()) {
            initAllFolderSizes(d, dirs);
            dir.folderSize += d.folderSize;
        }
        for (Entry<String, Integer> entry : dir.files.entrySet()) {
            dir.folderSize += entry.getValue();
        }
        dirs.add(dir);
    }
}

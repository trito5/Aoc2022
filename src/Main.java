import java.io.IOException;

import static utils.InputFetcher.createInputFiles;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        createInputFiles();
        Dec02.run();
        //Tests.run();
    }
}